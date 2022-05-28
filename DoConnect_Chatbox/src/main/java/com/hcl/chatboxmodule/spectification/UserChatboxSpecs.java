package com.hcl.chatboxmodule.spectification;

import com.hcl.chatboxmodule.model.entity.User;
import com.hcl.chatboxmodule.model.entity.UserChatbox;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class UserChatboxSpecs {
    public static Specification findByUserIds(int id1, int id2){
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.conjunction();

                query.where(root.get("user").in(User.builder().userId(id1).build(), User.builder().userId(id2).build()));
                query.groupBy(root.get("user"))
                        .having(criteriaBuilder.equal(criteriaBuilder.count(root.get("user")), 2));

                return predicate;
            }
        };
        return spec;
    }

    public static Specification findAllUserChatboxByUserId(int userId){
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.conjunction();

                Subquery<UserChatbox> subquery = query.subquery(UserChatbox.class);
                Root<UserChatbox> userChatbox = subquery.from(UserChatbox.class);
                Predicate equals = criteriaBuilder.equal(userChatbox.get("user"), User.builder().userId(userId).build());
                subquery.select(userChatbox.get("chatbox")).where(equals);

                predicate = criteriaBuilder.and(predicate, criteriaBuilder.notEqual(root.get("user"), User.builder().userId(userId).build()));

                return criteriaBuilder.and(predicate, root.get("chatbox").in(subquery));
            }
        };
        return spec;
    }

//    public static Specification findAllUserChatboxByUserId2(Integer userId){
//        Specification spec = new Specification() {
//            @Override
//            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
//
//                Predicate predicate = criteriaBuilder.conjunction();
//
//                Subquery<UserChatbox> subquery = query.subquery(UserChatbox.class);
//                Root<UserChatbox> userChatbox = subquery.from(UserChatbox.class);
//                Predicate equals = criteriaBuilder.equal(userChatbox.get("user"), User.builder().userId(userId).build());
//                subquery.select(userChatbox.get("chatbox")).where(equals);
//
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.notEqual(root.get("user"), User.builder().userId(userId).build()));
//
//                return criteriaBuilder.and(predicate, root.get("chatbox").in(subquery));
//            }
//        };
//        return spec;
//    }
}
