package com.hcl.questionandanswermodule.model.dto.responseDto;

import com.hcl.questionandanswermodule.model.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;


    public User toEntity() {
        return new User().builder()
                .userId(userId)
                .email(email)
                .password(password)
                .username(username)
                .phone(phone)
                .role(role)
                .build();
    }
}
