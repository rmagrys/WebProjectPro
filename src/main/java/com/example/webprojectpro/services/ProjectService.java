package com.example.webprojectpro.services;

import com.example.webprojectpro.exceptions.NotFoundException;
import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project getProjectById(Long id) {
        return projectRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("User with id = " + id + " not found")
                );
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }
}
