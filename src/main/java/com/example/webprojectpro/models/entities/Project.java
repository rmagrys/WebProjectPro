package com.example.webprojectpro.models.entities;

import com.example.webprojectpro.enums.Grade;
import com.example.webprojectpro.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Max(40)
    private String name;

    @Max(400)
    private String description;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Grade possibleGrade;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<UserProject> UserProjects;

}
