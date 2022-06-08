package com.hcl.questionandanswermodule.service;

import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDto;
import com.hcl.questionandanswermodule.model.entity.Topic;

import java.util.Optional;

public interface TopicService extends DAO<TopicDto, Topic>{

    Optional<TopicDto> findById(int id);

}
