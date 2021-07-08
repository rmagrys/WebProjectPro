package com.example.webprojectpro.models.dtos;

import com.example.webprojectpro.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Max(255)
    @NotNull
    private String email;

    @Max(125)
    @NotNull
    private char[] password;

    @Max(25)
    private String semester;

    @Max(25)
    private String learningGroup;

    @Max(40)
    private String firstName;

    @Max(40)
    private String lastName;

    private LocalDate createDate;

    private Timestamp lastLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

    private List<UserProjectDto> UserProjectsDto;
}

