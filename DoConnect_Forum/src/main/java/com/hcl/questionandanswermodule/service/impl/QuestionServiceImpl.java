package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.model.entity.Question;
import com.hcl.questionandanswermodule.model.entity.TopicDetails;
import com.hcl.questionandanswermodule.repository.QuestionManagement;
import com.hcl.questionandanswermodule.repository.QuestionRepository;
import com.hcl.questionandanswermodule.repository.TopicDetailsRepository;
import com.hcl.questionandanswermodule.service.QuestionService;
import com.hcl.questionandanswermodule.specifications.QuestionSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private QuestionManagement questionManagement;
    private TopicDetailsRepository topicDetailsRepository;
    private int minIndex = 0;


    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionManagement questionManagement,TopicDetailsRepository topicDetailsRepository) {
        this.questionRepository = questionRepository;
        this.questionManagement = questionManagement;
        this.topicDetailsRepository = topicDetailsRepository;
    }

    @Override
    public QuestionDto save(QuestionDto t) {
        if (t == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        return questionRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void deleteById(int id) {
        if (!questionRepository.findById(id).isPresent() ){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        questionRepository.deleteById(id);
    }

    @Override
    public void update(QuestionDto t) {
        if(!questionRepository.findById(t.getId()).isPresent()){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        questionRepository.save(t.toEntity());
    }

    @Override
    public List<QuestionDto> findAll(int paged) {
        if(paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.by("id").descending());
        return toDtoList(questionRepository.findQuestionByStatus(1, pageable).getContent());
    }

    @Override
    public Optional<QuestionDto> findById(int id) {
        if (id < 0){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if(questionRepository.findById(id).isPresent()) {
            return Optional.ofNullable(questionRepository.findById(id).get().toDto());
        }else {
            return null;
        }
    }

    @Override
    public List<QuestionDto> findByTopicId(int id, int paged) {
        if(id <= minIndex || paged < minIndex){
            throw new InvalidInputException("input invalid");
        }

        List<Question> result = new ArrayList<>();

        Pageable pageable = PageRequest.of(paged, 10, Sort.unsorted());

        List<TopicDetails> list = topicDetailsRepository.findAll(QuestionSpecs.searchQuestionByTopicId(id), pageable).getContent();
        list.forEach(e -> {
            result.add(e.getQuestion());
        });
        return toDtoList(result);
    }

    @Override
    public List<QuestionDto> searchByTitle(String title) {
        return toDtoList(questionRepository.findQuestionByTitle(title));
    }

    @Override
    public Question approvedQuestion(int id, int status) {
        if (questionRepository.findById(id).isEmpty() || status < 0 || status > 1){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
       return questionManagement.approval(id, status);
    }

    @Override
    public List<QuestionDto> findQuestionToApprove(int paged) {
        if (paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.by("id").descending());
        return toDtoList(questionRepository.findQuestionByStatus(0, pageable).getContent());
    }

    @Override
    public List<QuestionDto> findAll(String title, String content, String username) {
        List<Question> questions = questionRepository.findAll(QuestionSpecs.searchQuestion(title, content, username));
        return toDtoList(questions);
    }

    /*
    convert to dto
     */

    @Override
    public List<QuestionDto> toDtoList(List<Question> questionList){
        if(questionList == null || questionList.isEmpty()){
            return new ArrayList<>();
        }else {
            List<QuestionDto> list = new ArrayList<>();
            questionList.forEach(e -> {
                list.add(e.toDto());
            });
            return list;
        }
    }
}
