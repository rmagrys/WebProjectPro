package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.UserProjectDtoConverter;
import com.example.webprojectpro.models.dtos.UserProjectDto;
import com.example.webprojectpro.models.entities.UserProject;
import com.example.webprojectpro.services.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user-project")
@AllArgsConstructor
public class UserProjectController {

    private final UserProjectService userProjectService;

    @GetMapping(path = "/all")
    public List<UserProjectDto> getAll(){
        return UserProjectDtoConverter.listToDtoWithRelations(userProjectService.getAll());
    }

    @GetMapping(path = "/user/{id}")
    public List<UserProjectDto> getAllByUserId(@PathVariable final Long id){
        return UserProjectDtoConverter
                .listToDtoWithRelations(userProjectService
                        .getAll()
                        .stream()
                        .filter(userProject ->
                                userProject
                                        .getUser()
                                        .getId()
                                        .equals(id))
                        .collect(Collectors.toList()));
    }

    @GetMapping(path = "/project/{id}")
    public List<UserProjectDto> getAllByProjectId(@PathVariable final Long id){
        return UserProjectDtoConverter
                .listToDtoWithRelations(userProjectService
                        .getAll()
                        .stream()
                        .filter(userProject -> userProject
                                        .getProject()
                                        .getId()
                                        .equals(id))
                        .collect(Collectors.toList()));
    }

    @GetMapping(path = "/{id}")
    public UserProjectDto getProjectById(@PathVariable final Long id){
        return UserProjectDtoConverter.toDto(userProjectService.getOneById(id));
    }

    @PostMapping(path = "/user/{userId}/project/{projectId}")
    public Long saveProjectToUser(@PathVariable final Long userId, @PathVariable final Long projectId){
        return UserProjectDtoConverter.toDto(userProjectService.saveProjectToUser(userId, projectId))
                .getId();
    }

    @PatchMapping(path = "rate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long rateProject(@RequestBody final UserProjectDto userProjectDto, @PathVariable final Long id){
        return UserProjectDtoConverter.toDto(userProjectService.rateProject(userProjectDto, id))
                .getId();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserProject(@PathVariable final Long id){
        userProjectService.deleteById(id);
    }
}
