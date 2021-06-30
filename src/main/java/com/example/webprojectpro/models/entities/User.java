package com.example.webprojectpro.models.entities;

import com.example.webprojectpro.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private char[] password;

    private String firstName;

    private String lastName;

    private LocalDate createDate;

    private Timestamp lastLogin;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    @JoinTable
    private List<LearningGroup> learningGroups;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserProject> projects;
}