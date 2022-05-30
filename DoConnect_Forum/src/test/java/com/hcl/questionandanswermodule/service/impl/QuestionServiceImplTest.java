package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.model.entity.Question;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Assertions.assertEquals(3, questionService.findAll(0).size());
        Assertions.assertEquals(0, questionService.findAll(1).size());
        Assertions.assertThrows(InvalidInputException.class, () -> {
           questionService.findAll(-1);
        });
    }

    @Test
    void findById() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.findById(-1);
        });
        Assertions.assertEquals("abcd", questionService.findById(1).get().getContent());
        Assertions.assertNotEquals("abcd213", questionService.findById(1).get().getContent());
    }

    @Test
    void findByTopicId() {

    }


    @Test
    void approvedQuestion() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.approvedQuestion(-1, 2);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.approvedQuestion(2, 2);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.approvedQuestion(10000, 2);
        });
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.approvedQuestion(2, -3);
        });
        Assertions.assertEquals(1,  questionService.approvedQuestion(1, 1).getStatus());
        Assertions.assertNotEquals(0,  questionService.approvedQuestion(1, 1).getStatus());
        Assertions.assertNotEquals(2,  questionService.approvedQuestion(1, 1).getStatus());
        Assertions.assertNotEquals(1,  questionService.approvedQuestion(1, 0).getStatus());
    }

    @Test
    void findQuestionToApprove() {
        Assertions.assertEquals(1,  questionService.findQuestionToApprove(0).size());
        Assertions.assertEquals(0,  questionService.findQuestionToApprove(4).size());
        Assertions.assertThrows(InvalidInputException.class, () -> {
            questionService.findQuestionToApprove(-1);
        });
        Assertions.assertDoesNotThrow(() -> {
            questionService.findQuestionToApprove(10000);
        });
    }


    @Test
    void testFindAll() {
        List<Integer> list = IntStream.range(0, 5).boxed().collect(Collectors.toList());
        list.forEach(e -> {
            QuestionDto q = QuestionDto.builder()
                    .id(e)
                    .content("acb" + e)
                    .user(userDTO)
                    .status(1)
                    .build();
            questionService.save(q);
        });
        Assertions.assertEquals(4, questionService.findAll(0).size());
        Assertions.assertNotEquals(0, questionService.findAll(0).size());
        Assertions.assertEquals(0, questionService.findAll(5).size());
        Assertions.assertThrows(InvalidInputException.class, () -> {
           questionService.findAll(-1);
        });
    }

    @Test
    void toDtoList() {
        List<Question> questions = new ArrayList<>();
        List<Integer> list = IntStream.range(0, 5).boxed().collect(Collectors.toList());
        list.forEach(e -> {
            Question q = Question.builder()
                    .id(e)
                    .user(userDTO.toEntity())
                    .build();
            questions.add(q);
        });
        Assertions.assertEquals(5, questionService.toDtoList(questions).size());
        Assertions.assertNotEquals(0, questionService.toDtoList(questions).size());
        Assertions.assertEquals(0, questionService.toDtoList(null).size());
    }
}