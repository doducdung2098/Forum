package com.hcl.chatboxmodule.service.impl;

import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.model.entity.User;
import com.hcl.chatboxmodule.exception.InvalidInputException;
import com.hcl.chatboxmodule.repository.UserRepository;
import com.hcl.chatboxmodule.model.dto.responseDto.UserDto;
import com.hcl.chatboxmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private Integer minIndex = 0;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto t) {
        if (t == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        return userRepository.save(t.toEntity()).toDto();
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
    public void delete(int id) {
        if (findById(id) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        if (userRepository.findAll().isEmpty()){
            return new ArrayList<>();
        }else {
            return toDto(userRepository.findAll());
        }
    }

    @Override
    public Optional<UserDto> findById(int id) {
        if (id <= minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (userRepository.findById(id).isPresent()){
            return Optional.ofNullable(userRepository.findById(id).get().toDto());
        }else {
            return null;
        }

    }

    @Override
    public UserDto findByUsername(String username) {
        if (username == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        if (userRepository.findByUsername(username) == null){
            return null;
        }else
            return userRepository.findByUsername(username).toDto();
    }

    @Override
    public List<UserDto> findAll(int paged) {
        if (paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.unsorted());
        List<UserDto> users = toDto(userRepository.findAll(pageable).getContent());
        if (users.isEmpty()){
            return new ArrayList<>();
        }else {
            return users;
        }

    }

    /*
    convert to dto
     */

    @Override
    public List<UserDto> toDto(List<User> users) {
        if (users == null || users.isEmpty()){
            return new ArrayList<>();
        }else {
            List<UserDto> userDtos = new ArrayList<>();
            users.forEach(e ->{
                userDtos.add(e.toDto());
            });
            return userDtos;
        }
    }


}
