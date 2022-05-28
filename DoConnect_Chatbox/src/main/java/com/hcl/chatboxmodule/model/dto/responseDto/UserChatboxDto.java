package com.hcl.chatboxmodule.model.dto.responseDto;

import com.hcl.chatboxmodule.model.entity.UserChatbox;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserChatboxDto {
    private Integer id;
    private UserDto user;
    private ChatboxDto chatbox;
    private String lastUpdate;

    public UserChatbox toEntity(){
        return new UserChatbox().builder()
                .id(id)
                .lastUpdate(lastUpdate)
                .chatbox(chatbox.toEntity())
                .user(user.toEntity())
                .build();
    }
}
