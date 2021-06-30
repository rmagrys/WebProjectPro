package com.example.webprojectpro.converters;

import com.example.webprojectpro.models.dtos.SemesterDto;
import com.example.webprojectpro.models.entities.Semester;

public class SemesterDtoConverter {
    public static SemesterDto toDto(Semester semester) {
        return SemesterDto.builder().build();
    }

    public static Semester toEntity(SemesterDto semesterDto){
        return  Semester.builder().build();
    }
}
