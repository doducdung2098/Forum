package com.hcl.chatboxmodule.service.impl;

import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.model.entity.Message;
import com.hcl.chatboxmodule.exception.InvalidInputException;
import com.hcl.chatboxmodule.repository.MessageRepository;
import com.hcl.chatboxmodule.model.dto.responseDto.MessageDto;
import com.hcl.chatboxmodule.service.MessageService;
import com.hcl.chatboxmodule.spectification.MessageSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDto save(MessageDto t) {
        if (t == null){
            throw new InvalidInputException("input not found");
        }
        return messageRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void update(MessageDto t) {
        if (!messageRepository.findById(t.getId()).isPresent()){
            throw new InvalidInputException("id not found");
        }else {
            messageRepository.save(t.toEntity());
        }
    }

    @Override
    public void delete(int id) {
        if (!messageRepository.findById(id).isPresent()){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }else {
            messageRepository.deleteById(id);
        }
    }

    @Override
    public List<MessageDto> findAll() {
        return toListDto(messageRepository.findAll());
    }

    @Override
    public Optional<MessageDto> findById(int id) {
        if (id <= 0){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (messageRepository.findById(id).isPresent()){
            return Optional.ofNullable(messageRepository.findById(id).get().toDto());
        }
        else {
            return null;
        }
    }

    @Override
    public List<MessageDto> findMessageByChatboxId(int chatboxId) {
        if (chatboxId <= 0){
            throw new InvalidInputException("id not found");
        }else{
            return toListDto(messageRepository.findAll(MessageSpecs.findMessageByChatboxId(chatboxId)));
        }
    }


    /*
    convert to dto
     */
    public List<MessageDto> toListDto(List<Message> messages){
        if (messages.isEmpty()){
            return  null;
        }else {
            List<MessageDto> messageDtos = new ArrayList<>();
            messages.forEach(e ->{
                messageDtos.add(e.toDto());
            });
            return messageDtos;
        }
    }
}
