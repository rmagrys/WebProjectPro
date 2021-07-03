package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.ProjectDtoConverter;
import com.example.webprojectpro.models.dtos.ProjectDto;
import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@RequestParam Long id){
        return ProjectDtoConverter.toDto(projectService.getProjectById(id));
    }

    @GetMapping("/all")
    public List<ProjectDto> getAll(){
        return ProjectDtoConverter.listToDto(projectService.getAllProjects());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProject(@RequestBody ProjectDto projectDto){
        projectService.addProject(ProjectDtoConverter.toEntity(projectDto));
    }
}
