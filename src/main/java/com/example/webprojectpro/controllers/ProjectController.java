package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.ProjectDtoConverter;
import com.example.webprojectpro.models.dtos.ProjectDto;
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

    @GetMapping(path = "/{id}")
    public ProjectDto getProjectById(@PathVariable final Long id){
        return ProjectDtoConverter.toDto(projectService.getProjectById(id));
    }

    @GetMapping(path = "/all")
    public List<ProjectDto> getAll(){
        return ProjectDtoConverter.listToDto(projectService.getAllProjects());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long addProject(@RequestBody final ProjectDto projectDto){
       return projectService.addNewProject(
               ProjectDtoConverter.toEntity(projectDto)
       ).getId();
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long updateProject(@RequestBody  final ProjectDto projectDto, @PathVariable Long id){
        return ProjectDtoConverter.toDto(
                projectService.updateProject(projectDto, id)
        ).getId();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProjectById(@PathVariable Long id){
        projectService.deleteUserById(id);
    }
}
