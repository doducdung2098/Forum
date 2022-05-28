package com.hcl.chatboxmodule.model.dto.responseDto;

import com.hcl.chatboxmodule.model.entity.Chatbox;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChatboxDto {
    private Integer id;
    private String createdDate;

    public Chatbox toEntity(){
        return new Chatbox().builder()
                .id(id)
                .createdDate(createdDate)
                .build();
    }
}
