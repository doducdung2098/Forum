package com.hcl.questionandanswermodule.model.dto.responseDto;

import com.hcl.questionandanswermodule.model.entity.Answers;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswersDto {
    private int id;
    private String content;
    private UserDTO userDto;
    private QuestionDto questionDto;
    private String createdDate;
    private int status;
    public Answers toEntity(){
        return new Answers().builder()
                .content(content)
                .createdDate(createdDate)
                .status(status)
                .question(questionDto.toEntity())
                .user(userDto.toEntity())
                .id(id)
                .build();
    }
}
