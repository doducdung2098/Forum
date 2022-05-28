package com.hcl.questionandanswermodule.specifications;

import com.hcl.questionandanswermodule.model.entity.Answers;
import com.hcl.questionandanswermodule.model.entity.Question;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class AnswersSpecs {

    public static Specification findByQuestionId(int id){
        String idS = Integer.toString(id);
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), 1));
                if (!StringUtils.isEmpty(idS)){
                    Join<Answers, Question> questionJoin = root.join("question");
                    predicate = criteriaBuilder.and(predicate , criteriaBuilder.equal(questionJoin.get("id"),  id));
                }

                return predicate;
            }
        };
        return spec;
    }
}
