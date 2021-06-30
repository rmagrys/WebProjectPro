package com.example.webprojectpro.repositories;

import com.example.webprojectpro.models.entities.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository <UserProject, Long> {
}
