package com.example.webprojectpro.converters;

import com.example.webprojectpro.models.dtos.UserProjectDto;
import com.example.webprojectpro.models.entities.UserProject;

import java.util.List;
import java.util.stream.Collectors;

public class UserProjectDtoConverter {
    public static UserProjectDto toDto(UserProject userProject){
        return UserProjectDto
                .builder()
                    .id(userProject.getId())
                    .acquiredGrade(userProject.getAcquiredGrade())
                    .enabled(userProject.isEnabled())
                .build();
    }

    public static UserProject toEntity(UserProjectDto userProjectDto){
        return UserProject
                .builder()
                    .id(userProjectDto.getId())
                    .acquiredGrade(userProjectDto.getAcquiredGrade())
                    .enabled(userProjectDto.isEnabled())
                .build();
    }

    public static UserProjectDto toDtoWithRelations(UserProject userProject){
        return UserProjectDto
                .builder()
                    .id(userProject.getId())
                    .acquiredGrade(userProject.getAcquiredGrade())
                    .enabled(userProject.isEnabled())
                    .projectDto(ProjectDtoConverter.toDto(userProject.getProject()))
                    .userDto(UserDtoConverter.toDto(userProject.getUser()))
                .build();
    }

    public static List<UserProjectDto> listToDto(List<UserProject> userProjectList) {
        return userProjectList
                .stream()
                .map(UserProjectDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public static List<UserProjectDto> listToDtoWithRelations(List<UserProject> userProjectList) {
        return userProjectList
                .stream()
                .map(UserProjectDtoConverter::toDtoWithRelations)
                .collect(Collectors.toList());
    }
}
