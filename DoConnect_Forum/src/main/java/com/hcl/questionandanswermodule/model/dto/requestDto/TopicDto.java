package com.hcl.questionandanswermodule.model.dto.requestDto;

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
}
