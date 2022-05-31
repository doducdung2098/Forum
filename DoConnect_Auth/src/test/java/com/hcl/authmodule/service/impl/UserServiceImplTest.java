package com.hcl.authmodule.service.impl;

import com.hcl.authmodule.exception.InvalidInputException;
import com.hcl.authmodule.model.dto.responseDto.UserDto;
import com.hcl.authmodule.model.entity.User;
import com.hcl.authmodule.service.UserService;
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
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    private UserDto userDTO;
    private UserDto user;

    @BeforeEach
    void setup(){
        userDTO = UserDto.builder()
                .userId(1)
                .password("12345")
                .username("dungdo")
                .email("dungdo@123")
                .phone("0379242892")
                .role("admin")
                .build();
        user = UserDto.builder()
                .userId(2)
                .password("12345")
                .username("dungdoduc")
                .email("dungdo@123")
                .phone("0379242892")
                .role("admin")
                .build();
        userService.save(user);
    }

    @Test
    void save() {
        UserDto newUser = userService.save(userDTO);
        Assertions.assertEquals("dungdo", newUser.getUsername());
        Assertions.assertThrows(NullPointerException.class, () -> {
            userService.save(null);
        });
        Assertions.assertNotEquals("asdad", newUser.getUsername());
    }

    @Test
    void deleteById() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            userService.deleteById(-1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            userService.deleteById(10000);
        });
        Assertions.assertDoesNotThrow(() -> {
            userService.deleteById(2);
        });

    }

    @Test
    void update() {
        userDTO.setUsername("doducdung");
        userService.update(userDTO);
        Assertions.assertEquals("doducdung", userService.findById(1).get().getUsername());
        Assertions.assertNotEquals("dungdo", userService.findById(1).get().getUsername());
        Assertions.assertThrows(NullPointerException.class, () -> {
            userService.update(null);
        });
    }

    @Test
    void findAll() {
        Assertions.assertEquals(1, userService.findAll().size());
        Assertions.assertNotEquals(0, userService.findAll());

    }

    @Test
    void findByUsername() {
        UserDto newUser = userService.findByUsername("dungdoduc");
        Assertions.assertThrows(NullPointerException.class, () -> userService.findByUsername(null));
        Assertions.assertEquals(null, userService.findByUsername("admin"));
        Assertions.assertEquals("dungdoduc", newUser.getUsername());
    }

    @Test
    void findById() {
        Assertions.assertThrows(InvalidInputException.class, () -> userService.findById(-1));
        Assertions.assertEquals(null, userService.findById(10000));
        Assertions.assertDoesNotThrow(() -> userService.findById(1));
        Assertions.assertEquals("dungdoduc", userService.findById(2).get().getUsername());
    }

    @Test
    void toUserDTOList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = User.builder()
                    .userId(i)
                    .username("abc" + i)
                    .password("def" + i)
                    .build();
            users.add(u);
        }

        Assertions.assertEquals(10, userService.toDto(users).size());
        Assertions.assertNotEquals(0, userService.toDto(users).size());
    }

    @Test
    void testCheckLogin() {
    }
}