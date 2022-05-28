package com.hcl.questionandanswermodule.model.entity;

import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`user_id`")
    private int userId;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`phone`")
    private String phone;

    @Column(name = "`role`")
    private String role;

    public UserDTO toDto(){
        return new UserDTO().builder()
                .email(email)
                .userId(userId)
                .username(username)
                .password(password)
                .role(role)
                .phone(phone)
                .build();
    }
}
