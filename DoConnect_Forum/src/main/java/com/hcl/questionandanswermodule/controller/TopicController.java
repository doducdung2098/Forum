package com.hcl.questionandanswermodule.controller;

import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.helper.ResponseHandler;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@Controller
@RequestMapping("/api/v1/user")
public class TopicController {

    private QuestionService questionService;

    @Autowired
    public TopicController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/get-topic/{id}/paged/{paged}")
    public ResponseEntity getQuestionByTopicId(@PathVariable int id, @PathVariable int paged){
        List<QuestionDto> questionDtos = questionService.findByTopicId(id, paged);
        if (questionDtos.isEmpty()){
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.NO_CONTENT, "questions", questionDtos);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "questions", questionDtos);
        }
    }
}
