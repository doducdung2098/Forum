package com.hcl.chatboxmodule.model.entity;


import com.hcl.chatboxmodule.model.dto.responseDto.UserDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;

    public UserDto toDto(){
        return new UserDto().builder()
                .email(email)
                .password(password)
                .username(username)
                .userId(userId)
                .role(role)
                .build();
    }
}

