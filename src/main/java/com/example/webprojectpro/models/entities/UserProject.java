package com.example.webprojectpro.models.entities;

import com.example.webprojectpro.enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProject {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Grade acquiredGrade;

    private boolean enabled;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Project.class)
    private Project project;
}
