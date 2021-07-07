package com.example.webprojectpro.events;


import com.example.webprojectpro.enums.Grade;
import com.example.webprojectpro.enums.Role;
import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.models.entities.User;
import com.example.webprojectpro.models.entities.UserProject;
import com.example.webprojectpro.repositories.ProjectRepository;
import com.example.webprojectpro.repositories.UserProjectRepository;
import com.example.webprojectpro.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitialDataCreator {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserProjectRepository userProjectRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void createTestData() {


        final List<User> users = generateUsers();
        final List<Project> projects = generateProjects();
        final List<UserProject> userProjects = generateUserProjects();
        final Random rand = new Random();

        userProjects.forEach(userProject -> userProject.setProject(projects.get(rand.nextInt(projects.size()))));
        userProjects.forEach(userProject -> userProject.setUser(users.get(rand.nextInt(users.size()))));

        userRepository.saveAll(users);
        projectRepository.saveAll(projects);
        userProjectRepository.saveAll(userProjects);

        log.info("Test data saved to database!");
    }

    private List<User> generateUsers(){

        final char[] encodedPassword = passwordEncoder.encode(CharBuffer.wrap("test")).toCharArray();
        final List<User> users = new ArrayList<>();
        users.add(User.builder().email("test1@gmail.com").enabled(true).password(encodedPassword).role(Role.ADMIN).learningGroup("EF-ZI").semester("2021/2022").build());
        users.add(User.builder().email("test2@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-ZI").semester("2021/2022").build());
        users.add(User.builder().email("test3@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-DI").semester("2021/2022").build());
        users.add(User.builder().email("test4@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-DI").semester("2021/2022").build());
        users.add(User.builder().email("test5@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-DI").semester("2021/2022").build());
        users.add(User.builder().email("test6@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-ZI").semester("2021/2022").build());
        users.add(User.builder().email("test7@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-ZI").semester("2021/2022").build());
        users.add(User.builder().email("test8@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-ZI").semester("2021/2022").build());
        users.add(User.builder().email("test9@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-ZI").semester("2021/2022").build());
        users.add(User.builder().email("test10@gmail.com").enabled(true).password(encodedPassword).role(Role.STUDENT).learningGroup("EF-ZI").semester("2021/2022").build());
        return users;
    }

    private List<Project> generateProjects() {
        final List<Project> projects = new ArrayList<>();
        projects.add(Project.builder().enabled(true).name("test1").description("test").possibleGrade(Grade.FIVE).build());
        projects.add(Project.builder().enabled(true).name("test2").description("test").possibleGrade(Grade.FOUR_AND_HALF).build());
        projects.add(Project.builder().enabled(true).name("test3").description("test").possibleGrade(Grade.FOUR).build());
        projects.add(Project.builder().enabled(true).name("test4").description("test").possibleGrade(Grade.THREE_AND_HALF).build());
        projects.add(Project.builder().enabled(true).name("test5").description("test").possibleGrade(Grade.THREE).build());
        projects.add(Project.builder().enabled(true).name("test6").description("test").possibleGrade(Grade.FOUR).build());
        projects.add(Project.builder().enabled(true).name("test7").description("test").possibleGrade(Grade.FOUR).build());
        projects.add(Project.builder().enabled(true).name("test8").description("test").possibleGrade(Grade.FOUR).build());
        projects.add(Project.builder().enabled(true).name("test9").description("test").possibleGrade(Grade.FOUR).build());
        projects.add(Project.builder().enabled(true).name("test10").description("test").possibleGrade(Grade.FOUR).build());
        return projects;
    }

    private List<UserProject> generateUserProjects(){
        final List<UserProject> userProjects = new ArrayList<>();
        userProjects.add(UserProject.builder().acquiredGrade(Grade.NOT_RATED).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.FOUR).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.TWO).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.FIVE).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.FOUR_AND_HALF).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.FOUR).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.THREE).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.THREE_AND_HALF).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.NOT_RATED).enabled(true).build());
        userProjects.add(UserProject.builder().acquiredGrade(Grade.NOT_RATED).enabled(true).build());
        return userProjects;
    }

}
