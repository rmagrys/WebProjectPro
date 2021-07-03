package com.example.webprojectpro.services;

import com.example.webprojectpro.repositories.LearningGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LearningGroupService {

    private final LearningGroupRepository learningGroupRepository;
}
