package com.example.webprojectpro.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LearningGroup {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private boolean enabled;

    @ManyToOne
    @JoinColumn
    private Semester semester;

    @ManyToMany
    @JoinTable
    private List<User> students;
    
}
