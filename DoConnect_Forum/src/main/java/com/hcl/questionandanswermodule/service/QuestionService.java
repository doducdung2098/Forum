package com.hcl.questionandanswermodule.service;

import com.hcl.questionandanswermodule.model.entity.Question;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService extends DAO<QuestionDto, Question>{
     Optional<QuestionDto> findById(int id);
     List<QuestionDto> findByTopicId(int id, int paged);
     List<QuestionDto> searchByTitle(String title);
     Question approvedQuestion(int id, int status);
     List<QuestionDto> findQuestionToApprove(int paged);
     List<QuestionDto> findAllPageNumber(int paged);
     List<QuestionDto> findAll(String title, String content, String username);
}
