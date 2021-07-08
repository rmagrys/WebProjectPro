package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.ProjectDtoConverter;
import com.example.webprojectpro.models.dtos.ProjectDto;
import com.example.webprojectpro.services.ProjectService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping(path = "/{id}")
    @PreAuthorize("isAuthenticated()")
    public ProjectDto getProjectById(@PathVariable @NotNull final Long id){
        return ProjectDtoConverter.toDto(projectService.getProjectById(id));
    }

    @GetMapping(path = "/all")
    @PreAuthorize("isAuthenticated()")
    public List<ProjectDto> getAll(){
        return ProjectDtoConverter.listToDto(projectService.getAllProjects());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addProject(@RequestBody @Valid final ProjectDto projectDto){
       return projectService.addNewProject(
               ProjectDtoConverter.toEntity(projectDto)
       ).getId();
    }

    @PatchMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Long updateProject(@RequestBody @Valid final ProjectDto projectDto, @PathVariable @NotNull final Long id){
        return ProjectDtoConverter.toDto(
                projectService.updateProject(projectDto, id)
        ).getId();
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProjectById(@PathVariable @NotNull final Long id){
        projectService.deleteUserById(id);
    }
}
