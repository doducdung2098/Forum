package com.hcl.chatboxmodule.model.dto.responseDto;

import com.hcl.chatboxmodule.model.entity.Chatbox;
import com.hcl.chatboxmodule.model.entity.Message;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MessageDto {
    private Integer id;
    private String content;
    private String createdDate;
    private Chatbox chatbox;
    private UserDto user;

    public Message toEntity(){
        return new Message().builder()
                .chatbox(chatbox)
                .createdDate(createdDate)
                .id(id)
                .user(user.toEntity())
                .content(content)
                .build();
    }
}
