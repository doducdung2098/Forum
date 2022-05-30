package com.hcl.questionandanswermodule.model.dto.responseDto;

import com.hcl.questionandanswermodule.model.entity.Topic;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDto {
    private int id;
    private String name;
    private String description;

    public Topic toEntity(){
        return new Topic().builder()
                .id(id)
                .description(description)
                .name(name)
                .build();
    }
}
