package com.hcl.authmodule.model.entity;

import com.hcl.authmodule.model.dto.responseDto.UserDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
                .userId(userId)
                .username(username)
                .password(password)
                .phone(phone)
                .email(email)
                .role(role)
                .build();
    }
}
