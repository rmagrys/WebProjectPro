package com.example.webprojectpro.controllers;

import com.example.webprojectpro.services.LearningGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/learning-group")
@AllArgsConstructor
public class LearningGroupController {

    private final LearningGroupService learningGroupService;

}
