package com.hcl.questionandanswermodule.model.dto.responseDto;

import com.hcl.questionandanswermodule.model.entity.Question;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
    private int id;
    private String title;
    private String content;
    private String img;
    private UserDTO user;
    private String createdDate;
    private int status;
    public Question toEntity(){
        return new Question().builder()
                .content(content)
                .title(title)
                .id(id)
                .img(img)
                .createdDate(createdDate)
                .user(user.toEntity())
                .status(status)
                .build();
    }
}
