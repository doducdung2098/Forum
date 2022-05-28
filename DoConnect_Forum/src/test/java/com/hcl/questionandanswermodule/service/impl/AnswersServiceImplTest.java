package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.repository.AnswersRepository;
import com.hcl.questionandanswermodule.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;


@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AnswersServiceImplTest {

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private AnswersServiceImpl answersService;

    @Autowired
    private UserService userService;

    @Test
    void save() {
        UserDTO userDTO = UserDTO.builder()
                .username("admin")
                .password("admin@123")
                .build();
        UserDTO result = userService.save(userDTO);

        assertEquals("admin", result.getUsername());
    }

    @Test
    void testSave() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void getAllAnswers() {
    }

    @Test
    void findByQuestionId() {
    }

    @Test
    void approvedQuestion() {
    }

    @Test
    void findAnswersToApprove() {
    }

    @Test
    void toDto() {
    }
}