package com.hcl.questionandanswermodule.repository;

import com.hcl.questionandanswermodule.model.entity.TopicDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDetailsRepository extends JpaRepository<TopicDetails, Integer>, JpaSpecificationExecutor<TopicDetails> {
}
