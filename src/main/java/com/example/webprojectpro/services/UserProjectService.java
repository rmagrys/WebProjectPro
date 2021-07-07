package com.example.webprojectpro.services;

import com.example.webprojectpro.exceptions.NotFoundException;
import com.example.webprojectpro.facades.UserProjectFacade;
import com.example.webprojectpro.models.dtos.UserProjectDto;
import com.example.webprojectpro.models.entities.UserProject;
import com.example.webprojectpro.repositories.UserProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {

    private final UserProjectRepository userProjectRepository;
    private final UserProjectFacade userProjectFacade;


    public List<UserProject> getAll() {
       return userProjectRepository.findAll();
    }

    public UserProject getOneById(Long id) {
        return userProjectRepository
                .findById(id)
                .orElseThrow(
                        () ->  new NotFoundException("UserProject with id = [" + id + "] does not exist")
                );
    }

    public UserProject saveProjectToUser(Long userId, Long projectId) {
        UserProject userProject = userProjectFacade.assignProjectToUser(userId,projectId);
        return userProjectRepository.save(userProject);
    }


    public UserProject rateProject(UserProjectDto updateData, Long userProjectId) {
        UserProject userProjectToUpdate = getOneById(userProjectId);
        updateUserProject(userProjectToUpdate, updateData);
        return userProjectRepository.save(userProjectToUpdate);
    }

    private void updateUserProject(UserProject userProjectToUpdate, UserProjectDto updateData) {
        userProjectToUpdate.setAcquiredGrade(updateData.getAcquiredGrade());

    }

    public void deleteById(Long id) {
        UserProject userProject = getOneById(id);
        userProjectRepository.delete(userProject);
    }
}
