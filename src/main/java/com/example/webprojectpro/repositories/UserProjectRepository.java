package com.example.webprojectpro.repositories;

import com.example.webprojectpro.models.entities.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository extends JpaRepository <UserProject, Long> {
}
