package com.example.webprojectpro.facades;

import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.models.entities.User;
import com.example.webprojectpro.models.entities.UserProject;
import com.example.webprojectpro.services.ProjectService;
import com.example.webprojectpro.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProjectFacade {

    private final UserService userService;
    private final ProjectService projectService;

    public UserProject assignProjectToUser(Long userId, Long projectId){
        Project project = projectService.getProjectById(projectId);
        User user = userService.getUserById(userId);

        return UserProject
                .builder()
                    .project(project)
                    .user(user)
                .build();
    }
}
