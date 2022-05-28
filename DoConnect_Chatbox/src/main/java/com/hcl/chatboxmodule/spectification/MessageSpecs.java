package com.hcl.chatboxmodule.spectification;

import com.hcl.chatboxmodule.model.entity.Chatbox;
import com.hcl.chatboxmodule.model.entity.Message;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class MessageSpecs {
    public static Specification findMessageByChatboxId(int id){
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.conjunction();
                Join<Message, Chatbox> chatboxJoin = root.join("chatbox");
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(chatboxJoin.get("id"), id));

                return predicate;
            }
        };
        return spec;
    }
}
