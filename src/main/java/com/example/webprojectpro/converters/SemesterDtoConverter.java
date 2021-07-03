package com.example.webprojectpro.converters;

import com.example.webprojectpro.models.dtos.SemesterDto;
import com.example.webprojectpro.models.entities.Semester;

import java.util.List;
import java.util.stream.Collectors;

public class SemesterDtoConverter {
    public static SemesterDto toDto(Semester semester) {
        return SemesterDto.builder()
                .id(semester.getId())
                .name(semester.getName())
                .build();
    }

    public static Semester toEntity(SemesterDto semesterDto){
        return  Semester.builder()
                .id(semesterDto.getId())
                .name(semesterDto.getName())
                .build();
    }

    public static List<SemesterDto> listToDto(List<Semester> semesters){
        return semesters
                .stream()
                .map(SemesterDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public static List<Semester> listToEntity(List<SemesterDto> semesterDtos){
        return semesterDtos
                .stream()
                .map(SemesterDtoConverter::toEntity)
                .collect(Collectors.toList());
    }
}
