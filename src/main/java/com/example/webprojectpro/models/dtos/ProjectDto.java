package com.example.webprojectpro.models.dtos;

import com.example.webprojectpro.enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Long id;

    @Max(40)
    private String name;

    @Max(400)
    private String description;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Grade possibleGrade;

}
