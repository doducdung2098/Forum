package com.hcl.questionandanswermodule.model.dto.responseDto;

import com.hcl.questionandanswermodule.model.entity.TopicDetails;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDetailsDTO {
    private Integer id;
    private TopicDto topicDto;
    private QuestionDto questionDto;

    public TopicDetails toEntity(){
        return new TopicDetails().builder()
                .id(id)
                .question(questionDto.toEntity())
                .topic(topicDto.toEntity())
                .build();
    }
}
