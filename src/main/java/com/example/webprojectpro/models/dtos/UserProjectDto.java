package com.example.webprojectpro.models.dtos;

import com.example.webprojectpro.enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProjectDto {

    private long id;

    @Enumerated(EnumType.STRING)
    private Grade acquiredGrade;

    private boolean enabled;

    private UserDto userDto;

    private ProjectDto projectDto;
}