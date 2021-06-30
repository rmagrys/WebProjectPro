package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.SemesterDtoConverter;
import com.example.webprojectpro.models.dtos.SemesterDto;
import com.example.webprojectpro.models.entities.Semester;
import com.example.webprojectpro.services.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/semester")
@AllArgsConstructor
public class SemesterController {

    private final SemesterService semesterService;

    @GetMapping
    public List<SemesterDto> getAllSemesters(){
        return semesterService
                .getAllSemesters()
                .stream()
                .map(SemesterDtoConverter::toDto)
                .collect(Collectors.toList());
    }
}
