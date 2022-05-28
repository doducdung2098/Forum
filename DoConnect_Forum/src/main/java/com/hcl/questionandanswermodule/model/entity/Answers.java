package com.hcl.questionandanswermodule.model.entity;

import com.hcl.questionandanswermodule.model.dto.responseDto.AnswersDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "`answers`")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private int id;

    @ManyToOne
    @JoinColumn(name = "`user_id`")
    private User user;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`created_date`")
    private String createdDate;

    @ManyToOne
    @JoinColumn(name = "`question_id`")
    private Question question;

    @Column(name = "`status`")
    private int status;

    public AnswersDto toDto(){
        return new AnswersDto().builder()
                .id(id)
                .content(content)
                .createdDate(createdDate)
                .status(status)
                .questionDto(question.toDto())
                .userDto(user.toDto())
                .build();
    }
}
