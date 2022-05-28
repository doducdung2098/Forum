package com.hcl.questionandanswermodule.service;

import com.hcl.questionandanswermodule.model.entity.Answers;
import com.hcl.questionandanswermodule.model.dto.responseDto.AnswersDto;

import java.util.List;
import java.util.Optional;

public interface AnswersService extends DAO<AnswersDto, Answers>{
     Optional<AnswersDto> findById(int id);
     List<AnswersDto> findByQuestionId(int id, int paged);
     Answers approvedAnswers(int id, int status);
     List<AnswersDto> findAnswersToApprove(int paged);
}
