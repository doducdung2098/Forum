package com.hcl.questionandanswermodule.controller;

import com.hcl.questionandanswermodule.exception.DuplicatedException;
import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.helper.ResponseHandler;
import com.hcl.questionandanswermodule.model.dto.requestDto.AnswersApproveDTO;
import com.hcl.questionandanswermodule.model.dto.requestDto.QuestionApproveDTO;
import com.hcl.questionandanswermodule.model.dto.responseDto.AnswersDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.model.entity.Answers;
import com.hcl.questionandanswermodule.model.entity.Question;
import com.hcl.questionandanswermodule.service.AnswersService;
import com.hcl.questionandanswermodule.service.QuestionService;
import com.hcl.questionandanswermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private UserService userService;
    private QuestionService questionService;
    private AnswersService answersService;

    private final int failValue = 0;

    @Autowired
    public AdminController(UserService userService, QuestionService questionService, AnswersService answersService) {
        this.userService = userService;
        this.questionService = questionService;
        this.answersService = answersService;
    }

    @GetMapping("/manage-users/paged/{paged}")
    public ResponseEntity getAllUser(@PathVariable int paged){
        List<UserDTO> userList = userService.findAll(paged);
        if (userList.isEmpty()){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NO_CONTENT, "users", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "users", userList );
        }
    }

    @GetMapping("/manage-users/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable int id){
        Optional<UserDTO> user = userService.findById(id);
        if(user.isPresent()){
            userService.deleteById(id);
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
        }else {
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, null, null );
        }
    }

    @PostMapping("/manage-users/add-user")
    public ResponseEntity addUser(@RequestBody UserDTO user){
        if(user == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        UserDTO checkUser = userService.findByUsername(user.getUsername());
        if (checkUser != null){
            throw new DuplicatedException(Constant.ERROR_MESSAGE);
        }
        UserDTO newUser = userService.save(user);
        if(newUser == null){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, "newUser", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "newUser", newUser);
        }
    }

    @PutMapping("/manage-users/update-user/{id}")
    public ResponseEntity updateUser(@RequestBody UserDTO user, @PathVariable int id){
        userService.update(user);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
    }

    @GetMapping("/manage-questions/paged/{paged}")
    public ResponseEntity getAllQuestion(@PathVariable("paged") int paged){
        List<QuestionDto> questionList = questionService.findQuestionToApprove(paged);
        if (questionList.isEmpty()){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NO_CONTENT, "questions", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "questions", questionList );
        }
    }

    @GetMapping("/manage-answers/paged/{paged}")
    public ResponseEntity getAllAnswers(@PathVariable int paged){
        List<AnswersDto> answersList = answersService.findAnswersToApprove(paged);
        if (answersList.isEmpty()){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NO_CONTENT, "answers", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "answers", answersList );
        }
    }

    @GetMapping("/manage-questions/delete/{id}")
    public ResponseEntity deleteQuestionById(@PathVariable int id){
        Optional<QuestionDto> question = questionService.findById(id);
        if(question.isPresent()){
            questionService.deleteById(id);
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
        }else {
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, null, null );
        }
    }

    @PutMapping("/manage-questions/update-question")
    public ResponseEntity approvedQuestion(@RequestBody QuestionApproveDTO question){
        Question result = questionService.approvedQuestion(question.getQuestionId(), question.getStatus());
        if(result == null){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, null, null );
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
        }
    }

    @PutMapping("/manage-answers/update-answers")
    public ResponseEntity approvedAnswers(@RequestBody AnswersApproveDTO answers){
        Answers result = answersService.approvedAnswers(answers.getAnswersId(), answers.getStatus());
        if(result == null){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, null, null );
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
        }
    }

    @DeleteMapping("manage-questions/delete/{id}")
    public ResponseEntity deleteQuestion(@PathVariable int id){
        questionService.deleteById(id);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
    }

    @DeleteMapping("manage-answers/delete/{id}")
    public ResponseEntity deleteAnswers(@PathVariable int id){
        answersService.deleteById(id);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, null, null);
    }

}
