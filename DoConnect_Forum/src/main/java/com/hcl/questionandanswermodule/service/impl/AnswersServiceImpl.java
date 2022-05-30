package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.model.entity.Answers;
import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.repository.AnswersManagement;
import com.hcl.questionandanswermodule.repository.AnswersRepository;
import com.hcl.questionandanswermodule.model.dto.responseDto.AnswersDto;
import com.hcl.questionandanswermodule.service.AnswersService;
import com.hcl.questionandanswermodule.specifications.AnswersSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswersServiceImpl implements AnswersService {

    private AnswersRepository answersRepository;
    private int minIndex = 0;
    private AnswersManagement answersManagement;

    @Autowired
    public AnswersServiceImpl(AnswersRepository answersRepository, AnswersManagement answersManagement) {
        this.answersRepository = answersRepository;
        this.answersManagement = answersManagement;
    }

    @Override
    public AnswersDto save(AnswersDto t) {
        if (t == null){
            throw new InvalidInputException("input invalid");
        }
        Answers answers = answersRepository.save(t.toEntity());
        return answers.toDto();
    }

    public Answers save(Answers t) {
        if (t == null){
            throw new InvalidInputException("input invalid");
        }
        Answers answers = answersRepository.save(t);
        return answers;
    }

    @Override
    public void deleteById(int id) {
        if(!answersRepository.findById(id).isPresent()){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        answersRepository.deleteById(id);
    }

    public void update(AnswersDto t) {
        if(!answersRepository.findById(t.getId()).isPresent()){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        answersRepository.save(t.toEntity());
    }

    @Override
    public List<AnswersDto> findAll(int paged) {
        if (paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.unsorted());
        return toDto(answersRepository.findAll(pageable).getContent());
    }

    @Override
    public Optional<AnswersDto> findById(int id) {
        if (id < 0){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Optional<Answers> answers = answersRepository.findById(id);
        return answers.map(value -> Optional.ofNullable(value.toDto())).orElse(null);
    }

    @Override
    public List<AnswersDto> findByQuestionId(int id, int paged) {
        if (paged < minIndex || id < 0){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.unsorted());
//        return toDto(answersRepository.findByQuestionId(id, pageable).getContent());
        return toDto(answersRepository.findAll(AnswersSpecs.findByQuestionId(id), pageable).getContent());
    }

    @Override
    public Answers approvedAnswers(int id, int status) {
        if(answersRepository.findById(id).isEmpty() || status < 0 || status > 1){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        return answersManagement.update(id, status);
    }

    @Override
    public List<AnswersDto> findAnswersToApprove(int paged) {
        if (paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.unsorted());
        return toDto(answersRepository.findAnswersByStatus(0,pageable).getContent());
    }

    /*
    convert to dto
     */
    public List<AnswersDto> toDto(List<Answers> answers){
        if (answers == null || answers.isEmpty()){
            return new ArrayList<>();
        }else {
            List<AnswersDto> answersList = new ArrayList<>();
            answers.forEach(e -> {
                answersList.add(e.toDto());
            });
            return answersList;
        }
    }
}
