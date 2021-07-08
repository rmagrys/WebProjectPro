package com.example.webprojectpro.models.entities;

import com.example.webprojectpro.enums.Role;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Email
    @Max(255)
    @NotNull
    private String email;

    @Max(25)
    private String semester;

    @Max(25)
    private String learningGroup;

    @Max(125)
    @NotNull
    private char[] password;

    @Max(40)
    private String firstName;

    @Max(40)
    private String lastName;


    private LocalDate createDate;

    private Timestamp lastLogin;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<UserProject> UserProjects;
}