package com.hcl.questionandanswermodule.model.entity;

import com.hcl.questionandanswermodule.model.dto.responseDto.QuestionDto;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`question`")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`title`")
    private String title;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`img`")
    private String img;

    @ManyToOne
    @JoinColumn(name = "`user_id`")
    private User user;

    @Column(name = "`created_date`")
    private String createdDate;

    @Column(name = "`status`")
    private int status;

    public QuestionDto toDto(){
        return new QuestionDto().builder()
                .id(id)
                .content(content)
                .createdDate(createdDate)
                .title(title)
                .user(user.toDto())
                .status(status)
                .img(img)
                .build();
    }
}
