package com.hcl.questionandanswermodule.controller;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.helper.ResponseHandler;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.service.QuestionService;
import com.hcl.questionandanswermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@Controller
@RequestMapping("/api/v1/user")
public class QuestionController {

    private QuestionService questionService;
    private UserService userService;

    @Autowired
    public QuestionController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @GetMapping("/search-question")
    public ResponseEntity getQuestionByTitle(@RequestParam(name = "keyword") String title){
        List<QuestionDto> questionList = questionService.searchByTitle(title);
        if(questionList.isEmpty() || questionList == null){
            return ResponseHandler.generateResponse("fail!", HttpStatus.NOT_FOUND, "question", null);
        }else {
            return ResponseHandler.generateResponse("successfully!", HttpStatus.OK, "question", questionList);
        }
    }

    @GetMapping("/search-questions")
    public ResponseEntity getQuestions(@RequestParam(defaultValue = "") String title,
                                             @RequestParam(defaultValue = "") String content,
                                       @RequestParam(defaultValue = "") String username){
        System.out.println("asdand:sadasdbakjsndsajsandas");
        List<QuestionDto> questionList = questionService.findAll(title, content, username);
        if(questionList == null || questionList.isEmpty() ){
            return ResponseHandler.generateResponse("fail!",  HttpStatus.NOT_FOUND, "question", null);
        }else {
            return ResponseHandler.generateResponse("successfully!", HttpStatus.OK, "question", questionList);
        }
    }

    @GetMapping("/question/{id}")
    public ResponseEntity getQuestionById(@PathVariable int id){
        if (id <= 0)
            throw new InvalidInputException("input invalid");
        Optional<QuestionDto> question = questionService.findById(id);
        if(question.isPresent()){
            return ResponseHandler.generateResponse("Successfully!", HttpStatus.OK, "question", question.get());
        }else {
            return ResponseHandler.generateResponse("fail!", HttpStatus.NOT_FOUND, "question", null);
        }
    }

    @GetMapping("/questions")
    public ResponseEntity getAllQuestion(){
        List<QuestionDto> questionList = questionService.findAll(0);
        if (questionList == null || questionList.isEmpty()){
            return ResponseHandler.generateResponse("Dont have any question!", HttpStatus.NO_CONTENT, "questions", null);
        }else {
            return ResponseHandler.generateResponse("Get question list successfully!", HttpStatus.OK, "questions", questionList );
        }
    }

    @PostMapping("/raise-question")
    public ResponseEntity raiseQuestion(@RequestBody QuestionDto question){
        if (question.getUser() == null || question == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }

        QuestionDto newQuestion = questionService.save(question);

        if(newQuestion == null){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, "send", null);
        }else {
            //userService.sendEmail("ducdung2098@gmail.com");
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "question", newQuestion);
        }
    }


    @GetMapping("/topic/{topicId}/paged/{paged}")
    public ResponseEntity getQuestionByTopicId(@PathVariable int topicId, @PathVariable int paged){
        List<QuestionDto> questionList = questionService.findByTopicId(topicId, paged);
        if(questionList == null || questionList.isEmpty()){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, "question", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "question", questionList);
        }
    }
}
