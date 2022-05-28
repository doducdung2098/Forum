package com.hcl.questionandanswermodule.repository;

import com.hcl.questionandanswermodule.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer>{
}
