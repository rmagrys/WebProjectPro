package com.example.webprojectpro.controllers;

import com.example.webprojectpro.services.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-project")
@AllArgsConstructor
public class UserProjectController {

    private final UserProjectService userProjectService;
}
