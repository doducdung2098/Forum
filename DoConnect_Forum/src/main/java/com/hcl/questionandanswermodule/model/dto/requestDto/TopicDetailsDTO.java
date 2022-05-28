package com.hcl.questionandanswermodule.model.dto.requestDto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDetailsDTO {
    private int topicId;
    private int questionId;
}
