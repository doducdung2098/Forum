package com.hcl.chatboxmodule.model.entity;

import com.hcl.chatboxmodule.model.dto.responseDto.ChatboxDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "chatbox")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chatbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String createdDate;

    public ChatboxDto toDto(){
        return new ChatboxDto().builder()
                .id(id)
                .createdDate(createdDate)
                .build();
    }
}
