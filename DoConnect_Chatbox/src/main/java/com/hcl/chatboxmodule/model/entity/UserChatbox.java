package com.hcl.chatboxmodule.model.entity;

import com.hcl.chatboxmodule.model.dto.responseDto.UserChatboxDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_chatbox")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChatbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatbox_id")
    private Chatbox chatbox;

    private String lastUpdate;

    public UserChatboxDto toDto(){
        return new UserChatboxDto().builder()
                .id(id)
                .lastUpdate(lastUpdate)
                .chatbox(chatbox.toDto())
                .user(user.toDto())
                .build();
    }
}
