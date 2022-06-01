package com.hcl.chatboxmodule.service;

import com.hcl.chatboxmodule.model.dto.responseDto.ChatboxDto;
import com.hcl.chatboxmodule.model.entity.Chatbox;

import java.util.List;

public interface ChatboxService extends DAO<ChatboxDto>{

    List<ChatboxDto> toDto(List<Chatbox> chatboxes);
}
