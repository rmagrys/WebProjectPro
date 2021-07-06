package com.example.webprojectpro.converters;

import com.example.webprojectpro.models.dtos.ProjectDto;
import com.example.webprojectpro.models.entities.Project;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ProjectDtoConverter {
    static public ProjectDto toDto(Project project){
        return ProjectDto.builder()
                .id(project.getId())
                .possibleGrade(project.getPossibleGrade())
                .name(project.getName())
                .enabled(project.isEnabled())
                .build();
    }

    static public Project toEntity(ProjectDto projectDto){
        return Project.builder()
                .id(projectDto.getId())
                .possibleGrade(projectDto.getPossibleGrade())
                .name(projectDto.getName())
                .enabled(projectDto.isEnabled())
                .build();
    }


    static public List<Project> listToEntity(List<ProjectDto> projects) {
        return projects
                .stream()
                .map(ProjectDtoConverter::toEntity)
                .collect(Collectors.toList());
    }

    static public List<ProjectDto> listToDto(List<Project> projectDtos) {
        return projectDtos
                .stream()
                .map(ProjectDtoConverter::toDto)
                .collect(Collectors.toList());
    }
}
