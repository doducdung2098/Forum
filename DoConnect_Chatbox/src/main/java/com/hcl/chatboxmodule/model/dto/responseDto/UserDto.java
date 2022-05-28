package com.hcl.chatboxmodule.model.dto.responseDto;

import com.hcl.chatboxmodule.model.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;

    public User toEntity(){
        return new User().builder()
                .email(email)
                .username(username)
                .password(password)
                .phone(phone)
                .userId(userId)
                .role(role)
                .build();
    }
}
