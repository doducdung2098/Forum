package com.hcl.authmodule.model.dto.responseDto;

import com.hcl.authmodule.model.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
                .password(password)
                .userId(userId)
                .username(username)
                .phone(phone)
                .role(role)
                .build();
    }
}
