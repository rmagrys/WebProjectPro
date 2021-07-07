package com.example.webprojectpro.services;

import com.example.webprojectpro.exceptions.NotFoundException;
import com.example.webprojectpro.models.dtos.ProjectDto;
import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project getProjectById(Long id) {
        return projectRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Project with id = " + id + " not found")
                );
    }

    public List<Project> getAllProjects(){

        return projectRepository.findAll();
    }

    public Project addNewProject(Project project) {
       return projectRepository.save(project);
    }

    public Project updateProject(ProjectDto projectDto, Long projectId) {
        Project project = getProjectById(projectId);
        updateProjectValues(projectDto, project);
        return projectRepository.save(project);
    }

    private void updateProjectValues(ProjectDto projectDto, Project project) {
        if(projectDto.getName() != null){
            project.setName(projectDto.getName());
        }
        if(projectDto.getDescription()!= null){
            project.setDescription(projectDto.getDescription());
        }
        project.setEnabled(projectDto.isEnabled());
    }

    public void deleteUserById(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
