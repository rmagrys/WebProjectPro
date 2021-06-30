package com.example.webprojectpro.repositories;

import com.example.webprojectpro.models.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
