package com.example.webprojectpro.repositories;

import com.example.webprojectpro.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Long countUserByEmail(String mail);
    Optional<User> findByEmail(String mail);
}
