package com.hcl.chatboxmodule.service;

import com.hcl.chatboxmodule.model.dto.responseDto.UserDto;
import com.hcl.chatboxmodule.model.entity.User;

import java.util.List;

public interface UserService extends DAO<UserDto>{
     UserDto findByUsername(String username);
     List<UserDto> findAll(int paged);
    List<UserDto> toDto(List<User> users);
}
