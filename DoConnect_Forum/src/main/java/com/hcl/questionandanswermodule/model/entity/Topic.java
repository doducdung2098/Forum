package com.hcl.questionandanswermodule.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "`topic`")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`description`")
    private String description;
}
