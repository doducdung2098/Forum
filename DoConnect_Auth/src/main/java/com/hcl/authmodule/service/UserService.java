package com.hcl.authmodule.service;

import com.hcl.authmodule.model.dto.responseDto.UserDto;

import java.util.Optional;

public interface UserService extends DAO<UserDto>{
    public UserDto findByUsername(String username);
    public Optional<UserDto> findById(int id);
    public UserDto checkLogin(String username, String password);
}
