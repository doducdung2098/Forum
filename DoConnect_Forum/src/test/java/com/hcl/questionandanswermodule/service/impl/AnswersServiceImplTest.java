package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.model.dto.responseDto.AnswersDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.model.entity.Answers;
import com.hcl.questionandanswermodule.repository.AnswersRepository;
import com.hcl.questionandanswermodule.service.QuestionService;
import com.hcl.questionandanswermodule.service.UserService;
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

import static org.junit.Assert.assertEquals;


@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AnswersServiceImplTest {

    private UserDTO userDTO;
    private AnswersDto answersDto;
    private QuestionDto questionDto;

    private List<AnswersDto> userDTOList;


    @BeforeEach
    void setup(){
        userDTOList = new ArrayList<>();
        userDTO = UserDTO.builder()
                .username("admin")
                .password("admin@123")
                .build();
        UserDTO userTest = userService.save(userDTO);

        questionDto = QuestionDto.builder()
                .id(1)
                .content("abcd")
                .createdDate(new Instant().toDateTime().toString())
                .user(userTest)
                .status(1)
                .build();
        QuestionDto questionTest = questionService.save(questionDto);

        answersDto = AnswersDto.builder()
                .id(1)
                .content("abc")
                .userDto(userTest)
                .questionDto(questionTest)
                .status(0)
                .createdDate(new Instant().toDateTime().toString())
                .build();

        AnswersDto answersTest = answersService.save(answersDto);

    }

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private AnswersServiceImpl answersService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Test
    void save() {
        AnswersDto result = answersService.save(answersDto);
        assertEquals("abc", result.getContent());
    }

    @Test
    void deleteById() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.deleteById(1000);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.deleteById(-1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.deleteById(0);
        });
    }

    @Test
    void update() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.update(AnswersDto.builder().id(1000).build());
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.update(AnswersDto.builder().id(-1).build());
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.update(AnswersDto.builder().id(0).build());
        });
    }

    @Test
    void findAll() {
        Assertions.assertEquals(1, answersService.findAll(0).size());
        Assertions.assertEquals(0, answersService.findAll(1).size());
        Assertions.assertNotEquals(0, answersService.findAll(0).size());
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.findAll(-1);
        });
    }

    @Test
    void findById() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.findById(-1);
        });
        Assertions.assertEquals("abc", answersService.findById(1).get().getContent());
    }

    @Test
    void findByQuestionId() {
        Assertions.assertEquals(0 , answersService.findByQuestionId(1, 10).size());
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.findByQuestionId(1, -1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.findByQuestionId(-1, -1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.findByQuestionId(4, -1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.findByQuestionId(-10, 0);
        });
    }

    @Test
    void approvedAnswers() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
           answersService.approvedAnswers(-1, 2);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.approvedAnswers(1, 2);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.approvedAnswers(10000, 2);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            answersService.approvedAnswers(1, -3);
        });
        Assertions.assertEquals(1, answersService.approvedAnswers(1, 1).getStatus());
        Assertions.assertNotEquals(0, answersService.approvedAnswers(1, 1).getStatus());
        Assertions.assertNotEquals(2, answersService.approvedAnswers(1, 1).getStatus());
        Assertions.assertNotEquals(1, answersService.approvedAnswers(1, 0).getStatus());
    }

    @Test
    void findAnswersToApprove() {
        Assertions.assertEquals(1, answersService.findAnswersToApprove(0).size());
        Assertions.assertEquals(0, answersService.findAnswersToApprove(1).size());
        Assertions.assertThrows(InvalidInputException.class, ()->{
            answersService.findAnswersToApprove(-1);
        });
    }

    @Test
    void toDto() {
        Assertions.assertEquals(0 , answersService.toDto(new ArrayList<Answers>()).size());
    }
}