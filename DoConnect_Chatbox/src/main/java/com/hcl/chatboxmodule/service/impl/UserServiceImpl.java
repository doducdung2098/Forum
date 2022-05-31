package com.hcl.chatboxmodule.service.impl;

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

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto t) {
        if (t == null){
            throw new InvalidInputException("Invalid input");
        }
        return userRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void update(UserDto t) {
    }

    @Override
    public void delete(int id) {
        if (findById(id).isPresent()){
            userRepository.deleteById(id);
        }
        else {
            throw new InvalidInputException("id not found");
        }
    }

    @Override
    public List<UserDto> findAll() {
        return toDto(userRepository.findAll());
    }

    @Override
    public Optional<UserDto> findById(int id) {
        if (findById(id).isPresent()){
            return Optional.ofNullable(userRepository.findById(id).get().toDto());
        }else {
            return null;
        }

    }

    @Override
    public UserDto findByUsername(String username) {
        if (userRepository.findByUsername(username) == null){
            return  null;
        }else
        return userRepository.findByUsername(username).toDto();
    }

    @Override
    public List<UserDto> findAll(int paged) {
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
