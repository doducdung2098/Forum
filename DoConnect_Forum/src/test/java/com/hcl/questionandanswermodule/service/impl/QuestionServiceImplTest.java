package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.service.QuestionService;
import com.hcl.questionandanswermodule.service.TopicService;
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

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
class QuestionServiceImplTest {
    private UserDTO userDTO;
    private QuestionDto questionDto;
    private TopicDto topicDto;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private QuestionService questionService;

    @BeforeEach
    void setup(){
        userDTO = UserDTO.builder()
                .userId(1)
                .username("admin")
                .password("admin@123")
                .build();
        UserDTO userTest = userService.save(userDTO);

        topicDto = TopicDto.builder()
                .id(1)
                .name("basd")
                .build();
        TopicDto topic = topicService.save(topicDto);

        questionDto = QuestionDto.builder()
                .id(1)
                .content("abcd")
                .createdDate(new Instant().toDateTime().toString())
                .user(userTest)
                .title("xxx")
                .status(1)
                .build();
        QuestionDto questionDto1 = QuestionDto.builder()
                .id(2)
                .content("abcd")
                .title("yyy")
                .createdDate(new Instant().toDateTime().toString())
                .user(userTest)
                .status(0)
                .build();
        questionService.save(questionDto1);
        QuestionDto questionTest = questionService.save(questionDto);
    }
    @Test
    void save() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.save(null);
        });
        Assertions.assertEquals("abcd", questionService.save(questionDto).getContent());
        Assertions.assertNotEquals("abcsda", questionService.save(questionDto).getContent());
    }

    @Test
    void deleteById() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.deleteById(-1);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.deleteById(1000);
        });
        Assertions.assertDoesNotThrow( () -> {
            questionService.deleteById(2);
        });
    }

    @Test
    void update() {
        QuestionDto questionDto1 = QuestionDto.builder()
                .user(userDTO)
                .id(1000)
                .content("123456789")
                .createdDate(new Instant().toDateTime().toString())
                .build();
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.update(questionDto1);
        });

        questionDto1.setId(1);

        Assertions.assertDoesNotThrow(() -> {
            questionService.update(questionDto1);
        });

    }

    @Test
    void findAll() {
        Assertions.assertEquals(1, questionService.findAll(0).size());
        Assertions.assertEquals(0, questionService.findAll(1).size());
        Assertions.assertThrows(InvalidInputException.class, () -> {
           questionService.findAll(-1);
        });
    }

    @Test
    void findById() {
    }

    @Test
    void findByTopicId() {
    }

    @Test
    void searchByTitle() {

    }

    @Test
    void approvedQuestion() {
    }

    @Test
    void findQuestionToApprove() {
    }

    @Test
    void findAllPageNumber() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void toDtoList() {
    }
}