package com.hcl.questionandanswermodule.model.entity;

import com.hcl.questionandanswermodule.model.dto.responseDto.TopicDetailsDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "`topic_details`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private int id;

    @ManyToOne
    @JoinColumn(name = "`topic_id`", nullable=false)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "`question_id`", nullable=false)
    private Question question;

    public TopicDetailsDTO toDto(){
        return new TopicDetailsDTO().builder()
                .id(id)
                .questionDto(question.toDto())
                .topicDto(topic.toDto())
                .build();
    }
}
