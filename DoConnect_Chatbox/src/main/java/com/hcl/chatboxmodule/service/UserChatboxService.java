package com.hcl.chatboxmodule.service;

import com.hcl.chatboxmodule.model.dto.responseDto.UserChatboxDto;

import java.util.List;

public interface UserChatboxService extends DAO<UserChatboxDto>{

    List<UserChatboxDto> findAllChatboxByUserId(int id);
    List<UserChatboxDto> findUserChatboxByUserId(int userId1, int userId2);
}
