package com.hcl.authmodule.service.impl;

import com.hcl.authmodule.exception.DuplicatedException;
import com.hcl.authmodule.exception.InvalidInputException;
import com.hcl.authmodule.helper.Constant;
import com.hcl.authmodule.model.dto.responseDto.UserDto;
import com.hcl.authmodule.model.entity.User;
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
            throw new DuplicatedException(Constant.DUPLICATED_MESSAGE);
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
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        if (findById(t.getUserId()) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        userRepository.save(t.toEntity());
    }

    @Override
    public List<UserDto> findAll() {
        if (userRepository.findAll() == null || userRepository.findAll().isEmpty()){
            return new ArrayList<>();
        }else {
            return toDto(userRepository.findAll());
        }
    }

    @Override
    public UserDto findByUsername(String username){
        if (username == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        if (userRepository.findByUsername(username) == null){
            return null;
        }
        UserDto userDto = userRepository.findByUsername(username).toDto();
        return userDto;
    }

    @Override
    public Optional<UserDto> findById(int id) {
        int minIndex = 0;
        if(id < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (userRepository.findById(id) == null){
            return null;
        }
        return Optional.ofNullable(userRepository.findById(id).get().toDto());
    }

    @Override
    public List<UserDto> toDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        if (users == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        users.forEach(e -> {userDtos.add(e.toDto());});
        return userDtos;
    }

    @Override
    public UserDto checkLogin(String username, String password) {
        if (username == null || password == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        System.out.println(DigestUtils.md5Hex("12345").toUpperCase());
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        return userRepository.findByUsernameAndPassword(username, md5Hex).toDto();
    }

}
