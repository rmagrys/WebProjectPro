package com.example.webprojectpro.services;

import com.example.webprojectpro.models.entities.UserProject;
import com.example.webprojectpro.repositories.UserProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProjectService {

    private final UserProjectRepository userProjectRepository;

}
