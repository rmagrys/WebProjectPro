package com.example.webprojectpro.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private boolean enabled;

    @OneToMany(
            mappedBy = "semester",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LearningGroup> learningGroups;

}
