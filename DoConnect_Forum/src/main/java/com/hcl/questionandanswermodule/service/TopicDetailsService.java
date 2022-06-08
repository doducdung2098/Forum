package com.hcl.questionandanswermodule.service;

import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDetailsDTO;
import com.hcl.questionandanswermodule.model.entity.TopicDetails;

import java.util.Optional;

public interface TopicDetailsService extends DAO<TopicDetailsDTO, TopicDetails>{
    Optional<TopicDetailsDTO> findById(int id);
}
