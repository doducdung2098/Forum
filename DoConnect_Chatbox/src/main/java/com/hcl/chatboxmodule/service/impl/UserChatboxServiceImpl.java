package com.hcl.chatboxmodule.service.impl;

import com.hcl.chatboxmodule.model.entity.UserChatbox;
import com.hcl.chatboxmodule.exception.InvalidInputException;
import com.hcl.chatboxmodule.repository.UserChatboxRepository;
import com.hcl.chatboxmodule.model.dto.responseDto.UserChatboxDto;
import com.hcl.chatboxmodule.service.UserChatboxService;
import com.hcl.chatboxmodule.service.UserService;
import com.hcl.chatboxmodule.spectification.UserChatboxSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.chatboxmodule.helper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserChatboxServiceImpl implements UserChatboxService {

    private UserChatboxRepository userChatboxRepository;
    private UserService userService;
    private Integer minIndex = 0;

    @Autowired
    public UserChatboxServiceImpl(UserChatboxRepository userChatboxRepository, UserService userService) {
        this.userChatboxRepository = userChatboxRepository;
        this.userService = userService;
    }

    @Override
    public UserChatboxDto save(UserChatboxDto t) {
        if (t == null){
            return null;
        }else {
            return userChatboxRepository.save(t.toEntity()).toDto();
        }
    }

    @Override
    public void update(UserChatboxDto t) {
    }

    @Override
    public void delete(int id) {
        if (findById(id).isPresent()){
            userChatboxRepository.deleteById(id);
        }else {
            throw new InvalidInputException("id not found");
        }
    }

    @Override
    public List<UserChatboxDto> findAll() {
        return toListDto(userChatboxRepository.findAll());
    }

    @Override
    public Optional<UserChatboxDto> findById(int id) {
        if (id <= minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        return Optional.empty();
    }

    @Override
    public List<UserChatboxDto> findAllChatboxByUserId(int id) {
        if (!userService.findById(id).isPresent()){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (userChatboxRepository.findAll(UserChatboxSpecs.findAllUserChatboxByUserId(id)).isEmpty()){
            return null;
        }else {
            return toListDto(userChatboxRepository.findAll(UserChatboxSpecs.findAllUserChatboxByUserId(id)));
        }
    }

    @Override
    public List<UserChatboxDto> findUserChatboxByUserId(int userId1, int userId2) {
        if (userId1 <= minIndex || userId2 <= minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (userChatboxRepository.findAll(UserChatboxSpecs.findByUserIds(userId1, userId2)).isEmpty()){
            return null;
        }else {
            return toListDto(userChatboxRepository.findAll(UserChatboxSpecs.findByUserIds(userId1, userId2)));
        }

    }

    /*
    convert to Dto
     */

    public List<UserChatboxDto> toListDto(List<UserChatbox> userList){
        if (userList.isEmpty()){
            return null;
        }else {
            List<UserChatboxDto> userDtos = new ArrayList<>();
            userList.forEach(e ->{
                userDtos.add(e.toDto());
            });
            return userDtos;
        }
    }
}
