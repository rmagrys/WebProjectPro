package com.example.webprojectpro.models.dtos;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    private char[] password;

    private String semester;

    private String learningGroup;

    private String firstName;

    private String lastName;

    private LocalDate createDate;

    private Timestamp lastLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

    private List<UserProjectDto> UserProjectsDto;
}

