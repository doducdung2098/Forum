package com.hcl.questionandanswermodule.repository;

import com.hcl.questionandanswermodule.model.entity.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class QuestionManagement {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Question approval(int id, int status){
        Question question = em.find(Question.class, id);
        question.setStatus(status);
        return em.merge(question);
    }
}
