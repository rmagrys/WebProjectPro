package com.example.webprojectpro.services;

import com.example.webprojectpro.models.entities.Semester;
import com.example.webprojectpro.repositories.SemesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }
}
