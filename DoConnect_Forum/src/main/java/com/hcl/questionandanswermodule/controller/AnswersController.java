package com.hcl.questionandanswermodule.controller;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.helper.ResponseHandler;
import com.hcl.questionandanswermodule.model.dto.responseDto.AnswersDto;
import com.hcl.questionandanswermodule.service.AnswersService;
import com.hcl.questionandanswermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@RestController
@RequestMapping("/api/v1/user")
public class AnswersController {

    private AnswersService answersService;
    private UserService userService;

    @Autowired
    public AnswersController(AnswersService answersService, UserService userService) {
        this.answersService = answersService;
        this.userService = userService;
    }

    @GetMapping("/question-answers/{id}/paged/{paged}")
    public ResponseEntity getAnswersList(@PathVariable int id, @PathVariable int paged){
        List<AnswersDto> answersList = answersService.findByQuestionId(id, paged);
        if(answersList == null || answersList.isEmpty()){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, "answers", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "answers", answersList);
        }
    }

    @PostMapping("/raise-answers")
    public ResponseEntity raiseAnswers(@RequestBody AnswersDto answers){
        if (answers.getUserDto() == null || answers == null)
            throw new InvalidInputException("input invalid");
        AnswersDto newAnswers = answersService.save(answers);
        if(newAnswers == null){
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, "answers", null);
        }else {
//            userService.sendEmail("ducdung2098@gmail.com");
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "answers", newAnswers);
        }
    }
}
