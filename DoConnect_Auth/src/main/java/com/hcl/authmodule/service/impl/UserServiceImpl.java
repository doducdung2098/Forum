package com.hcl.authmodule.service.impl;

import com.hcl.authmodule.exception.DuplicatedException;
import com.hcl.authmodule.model.dto.responseDto.UserDto;
import com.hcl.authmodule.model.entity.User;
import com.hcl.authmodule.exception.InvalidInputException;
import com.hcl.authmodule.repository.UserRepository;
import com.hcl.authmodule.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto t) {
        UserDto checkUser = findByUsername(t.getUsername());
        if (checkUser != null){
            throw new DuplicatedException("User existed!");
        }
        String password = t.getPassword();
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        t.setPassword(md5Hex);
        return userRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void deleteById(int id) {
        if (findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }

    @Override
    public void update(UserDto t) {
        if (t == null){
            throw new InvalidInputException("input invalid");
        }
        userRepository.save(t.toEntity());
    }

    @Override
    public List<UserDto> findAll() {
        return toListDto(userRepository.findAll());
    }

    @Override
    public UserDto findByUsername(String username){
        if (username == null){
            throw new InvalidInputException("input invalid");
        }
        UserDto userDto = userRepository.findByUsername(username).toDto();
        return userDto;
    }

    @Override
    public Optional<UserDto> findById(int id) {
        int minIndex = 0;
        if(id < minIndex){
            throw new InvalidInputException("id invalid");
        }
        return Optional.ofNullable(userRepository.findById(id).get().toDto());
    }

    @Override
    public UserDto checkLogin(String username, String password) {
        if (username == null || password == null){
            throw new InvalidInputException("input not found");
        }
        System.out.println(DigestUtils.md5Hex("12345").toUpperCase());
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        return userRepository.findByUsernameAndPassword(username, md5Hex).toDto();
    }

    public List<UserDto> toListDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        if (users.isEmpty()){
            return null;
        }
        users.forEach(e -> {userDtos.add(e.toDto());});
        return userDtos;
    }
}
