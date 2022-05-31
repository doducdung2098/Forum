package com.hcl.authmodule.service;

import com.hcl.authmodule.model.dto.responseDto.UserDto;
import com.hcl.authmodule.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends DAO<UserDto>{
    UserDto findByUsername(String username);
    Optional<UserDto> findById(int id);
    List<UserDto> toDto(List<User> users);
    UserDto checkLogin(String username, String password);
}
