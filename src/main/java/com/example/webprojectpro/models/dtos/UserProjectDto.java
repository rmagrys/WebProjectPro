package com.example.webprojectpro.models.dtos;

import com.example.webprojectpro.enums.Grade;
import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProjectDto  {

    private long id;

    @Enumerated(EnumType.STRING)
    private Grade acquiredGrade;

    private boolean enabled;

    private UserDto userDto;

    private ProjectDto projectDto;
}
