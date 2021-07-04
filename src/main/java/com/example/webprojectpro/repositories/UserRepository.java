package com.example.webprojectpro.repositories;

import com.example.webprojectpro.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Long countUserByEmail(String mail);
}
