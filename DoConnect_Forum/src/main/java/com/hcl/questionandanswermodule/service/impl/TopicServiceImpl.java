package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDto;
import com.hcl.questionandanswermodule.repository.TopicRepository;
import com.hcl.questionandanswermodule.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public TopicDto save(TopicDto t) {
        if (t == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        return topicRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(TopicDto t) {

    }

    @Override
    public List<TopicDto> findAll(int paged) {
        return null;
    }

    @Override
    public Optional<TopicDto> findById(int id) {
        return Optional.empty();
    }
}
