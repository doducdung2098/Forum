package com.hcl.questionandanswermodule.repository;

import com.hcl.questionandanswermodule.model.entity.Answers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class AnswersManagement {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Answers update(int id, int status){
        Answers answers = em.find(Answers.class, id);
        answers.setStatus(status);
        return em.merge(answers);
    }
}
