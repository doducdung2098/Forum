package com.hcl.chatboxmodule.service.impl;

import com.hcl.chatboxmodule.exception.InvalidInputException;
import com.hcl.chatboxmodule.model.dto.responseDto.ChatboxDto;
import com.hcl.chatboxmodule.model.dto.responseDto.UserDto;
import com.hcl.chatboxmodule.model.entity.Chatbox;
import com.hcl.chatboxmodule.service.ChatboxService;
import com.hcl.chatboxmodule.service.UserService;
import org.joda.time.Instant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ChatboxServiceImplTest {

    private UserDto userDto;
    private ChatboxDto chatboxDto;
    private String date;

    @Autowired
    private ChatboxService chatboxService;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setup(){
        userDto = UserDto.builder()
                .userId(1)
                .password("12345")
                .username("dungdo")
                .email("dungdo@123")
                .phone("0379242892")
                .role("admin")
                .build();
        userService.save(userDto);

        chatboxDto = ChatboxDto.builder()
                .id(1)
                .createdDate( new Instant().toDateTime().toString())
                .build();
        date = chatboxDto.getCreatedDate();
        ChatboxDto chatboxDtoTest = ChatboxDto.builder().id(2)
                .createdDate(new Instant().toDateTime().toString()).build();
        chatboxService.save(chatboxDtoTest);
    }

    @Test
    void save() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            chatboxService.save(null);
        });
        Assertions.assertDoesNotThrow(() -> chatboxService.save(chatboxDto));
        Assertions.assertEquals(1, chatboxService.save(chatboxDto).getId());
        Assertions.assertNotEquals(0, chatboxService.save(chatboxDto).getId());
    }

    @Test
    void update() {
        String date = new Instant().toDateTime().toString();
        chatboxDto.setCreatedDate(date);
        Assertions.assertThrows(NullPointerException.class, () -> {
            chatboxService.update(null);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            chatboxService.update(ChatboxDto.builder().id(1000).build());
        });
    }

    @Test
    void delete() {

        Assertions.assertThrows(InvalidInputException.class, () -> {
            chatboxService.delete(-1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            chatboxService.delete(10000);
        });
        Assertions.assertDoesNotThrow(() -> chatboxService.delete(2));
    }

    @Test
    void findAll() {
        List<ChatboxDto> chatboxDtos = new ArrayList<>();
        for (int i = 0; i < 5; i++ ){
            ChatboxDto c = ChatboxDto.builder()
                    .createdDate(new Instant().toDateTime().toString())
                    .build();
            chatboxService.save(c);
        }
        Assertions.assertEquals(7, chatboxService.findAll().size());
        Assertions.assertNotEquals(0, chatboxService.findAll().size());

    }

    @Test
    void findById() {
        Assertions.assertEquals(null, chatboxService.findById(10000));
        Assertions.assertThrows(InvalidInputException.class, () -> chatboxService.findById(-11));
        Assertions.assertDoesNotThrow(() -> chatboxService.findById(1).get().getCreatedDate());
    }

    @Test
    void toListDto() {
        List<Chatbox> chatboxes = new ArrayList<>();
        for (int i = 0; i < 5; i++ ){
            Chatbox c = Chatbox.builder()
                    .createdDate(new Instant().toDateTime().toString())
                    .build();
            chatboxes.add(c);
        }
        Assertions.assertEquals(5, chatboxService.toDto(chatboxes).size());
        Assertions.assertNotEquals(0, chatboxService.toDto(chatboxes).size());
        Assertions.assertThrows(NullPointerException.class, () -> chatboxService.toDto(null));
    }
}