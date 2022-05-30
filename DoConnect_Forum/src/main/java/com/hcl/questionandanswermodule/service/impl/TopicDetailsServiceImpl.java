package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDetailsDTO;
import com.hcl.questionandanswermodule.repository.TopicDetailsRepository;
import com.hcl.questionandanswermodule.service.TopicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicDetailsServiceImpl implements TopicDetailsService {

    private TopicDetailsRepository topicDetailsRepository;

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

    }

    @Override
    public void update(TopicDetailsDTO t) {

    }

    @Override
    public List<TopicDetailsDTO> findAll(int paged) {
        return null;
    }
}
