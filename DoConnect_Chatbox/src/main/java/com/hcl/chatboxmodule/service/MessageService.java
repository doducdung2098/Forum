package com.hcl.chatboxmodule.service;

import com.hcl.chatboxmodule.model.dto.responseDto.MessageDto;

import java.util.List;

public interface MessageService extends DAO<MessageDto>{
    List<MessageDto> findMessageByChatboxId(int chatboxId);
}
