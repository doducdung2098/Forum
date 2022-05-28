package com.hcl.questionandanswermodule.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "`topic_details`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
