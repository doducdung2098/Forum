package com.hcl.questionandanswermodule.specifications;

import com.hcl.questionandanswermodule.model.entity.Question;
import com.hcl.questionandanswermodule.model.entity.Topic;
import com.hcl.questionandanswermodule.model.entity.TopicDetails;
import com.hcl.questionandanswermodule.model.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class QuestionSpecs {
    public static Specification searchQuestion(String title, String content, String username){
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(!StringUtils.isEmpty(title)){
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("title"), "%" + title + "%"));
                }
                if(!StringUtils.isEmpty(content)){
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("content"), "%" + content + "%"));
                }
                if (!StringUtils.isEmpty(username)){
                    Join<Question, User> questionUserJoin = root.join("user");
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(questionUserJoin.get("username"), "%" + username + "%"));
                }
                query.orderBy( criteriaBuilder.asc(root.get("id")));
                return predicate;
            }
        };
        return spec;
    }

    public static Specification searchQuestionByTopicId(int id){
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.conjunction();

                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("topic"), Topic.builder().id(id).build()));

                Join<TopicDetails, Question> questionJoin = root.join("question");
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(questionJoin.get("status"), 1 ));

                query.orderBy(criteriaBuilder.desc(root.get("id")));

                return predicate;
            }
        };
        return spec;
    }

}
