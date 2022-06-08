package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDetailsDTO;
import com.hcl.questionandanswermodule.repository.TopicDetailsRepository;
import com.hcl.questionandanswermodule.service.TopicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicDetailsServiceImpl implements TopicDetailsService {

    private TopicDetailsRepository topicDetailsRepository;
    private int minIndex = 0;

    @Autowired
    public TopicDetailsServiceImpl(TopicDetailsRepository topicDetailsRepository) {
        this.topicDetailsRepository = topicDetailsRepository;
    }

    @Override
    public TopicDetailsDTO save(TopicDetailsDTO t) {
        if (t == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        return topicDetailsRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void deleteById(int id) {
        if(findById(id) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
    }

    @Override
    public void update(TopicDetailsDTO t) {
        if (t == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (findById(t.getId()) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }

    }

    @Override
    public List<TopicDetailsDTO> findAll(int paged) {
        if(paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        return null;
    }

    @Override
    public Optional<TopicDetailsDTO> findById(int id) {
        return Optional.empty();
    }
}
