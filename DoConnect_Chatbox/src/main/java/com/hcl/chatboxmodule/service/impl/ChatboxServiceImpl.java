package com.hcl.chatboxmodule.service.impl;

import com.hcl.chatboxmodule.exception.InvalidInputException;
import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.model.entity.Chatbox;
import com.hcl.chatboxmodule.repository.ChatboxRepository;
import com.hcl.chatboxmodule.model.dto.responseDto.ChatboxDto;
import com.hcl.chatboxmodule.service.ChatboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatboxServiceImpl implements ChatboxService {

    @Autowired
    private ChatboxRepository chatboxRepository;

    @Override
    public ChatboxDto save(ChatboxDto t) {
        if (t == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        return chatboxRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void update(ChatboxDto t) {
        if (findById(t.getId()) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        chatboxRepository.save(t.toEntity());
    }

    @Override
    public void delete(int id) {
        if (findById(id) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        chatboxRepository.deleteById(id);
    }

    @Override
    public List<ChatboxDto> findAll() {
        if (chatboxRepository.findAll().isEmpty()){
            return new ArrayList<>();
        }
        return toDto(chatboxRepository.findAll());
    }

    public List<ChatboxDto> findAll(int paged) {
        if (paged < 0){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }

        return toDto(chatboxRepository.findAll());
    }

    @Override
    public Optional<ChatboxDto> findById(int id) {
        if (id <= 0){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (chatboxRepository.findById(id).isPresent()){
            return Optional.ofNullable(chatboxRepository.findById(id).get().toDto());
        }else {
            return null;
        }
    }


    /*
    convert to dto
     */
    @Override
    public List<ChatboxDto> toDto(List<Chatbox> chatboxList){
        if (chatboxList == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        if (chatboxList.isEmpty()){
            return new ArrayList<>();
        }else {
            List<ChatboxDto> chatboxDtos = new ArrayList<>();
            chatboxList.forEach(e ->{
                chatboxDtos.add(e.toDto());
            });
            return chatboxDtos;
        }
    }
}
