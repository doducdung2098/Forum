package com.hcl.chatboxmodule.model.entity;

import com.hcl.chatboxmodule.model.dto.responseDto.MessageDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;
    private String createdDate;

    @ManyToOne
    @JoinColumn(name = "chatbox_id")
    private Chatbox chatbox;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MessageDto toDto(){
        return new MessageDto().builder()
                .chatbox(chatbox)
                .createdDate(createdDate)
                .id(id)
                .user(user.toDto())
                .content(content)
                .build();
    }
}
