package com.example.webprojectpro.converters;

import com.example.webprojectpro.models.dtos.LearningGroupDto;
import com.example.webprojectpro.models.entities.LearningGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LearningGroupDtoConverter {

    public static LearningGroupDto toDto(LearningGroup learningGroup){
        return LearningGroupDto.builder()
                .id(learningGroup.getId())
                .name(learningGroup.getName())
                .enabled(learningGroup.isEnabled())
                .build();
    }

    public static LearningGroup toEntity(LearningGroupDto learningGroupDto){
        return LearningGroup.builder()
                .id(learningGroupDto.getId())
                .name(learningGroupDto.getName())
                .enabled(learningGroupDto.isEnabled())
                .build();
    }

    public static List<LearningGroupDto> listToDto(List<LearningGroup> learningGroups){
        return learningGroups
                .stream()
                .map(LearningGroupDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public static List<LearningGroup> listToEntity(List<LearningGroupDto> learningGroupDtos) {
        return learningGroupDtos
                .stream()
                .map(LearningGroupDtoConverter::toEntity)
                .collect(Collectors.toList());
    }
}
