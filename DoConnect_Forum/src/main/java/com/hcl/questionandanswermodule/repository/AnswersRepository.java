package com.hcl.questionandanswermodule.repository;

import com.hcl.questionandanswermodule.model.entity.Answers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Integer>, JpaSpecificationExecutor<Answers> {

    Page<Answers> findAnswersByStatus(int status, Pageable pageable);

    Page<Answers> findAll(Specification<Answers> answersSpecification, Pageable pageable);
}
