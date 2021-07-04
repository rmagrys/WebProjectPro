package com.example.webprojectpro.services;

import com.example.webprojectpro.exceptions.NotFoundException;
import com.example.webprojectpro.exceptions.NotUniqueException;
import com.example.webprojectpro.models.dtos.UserDto;
import com.example.webprojectpro.models.entities.User;
import com.example.webprojectpro.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveNewUser(User user) {
        user.setCreateDate(LocalDate.now());
        user.setLastLogin(Timestamp.valueOf(LocalDateTime.now()));
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User with id = [" + id + "]does not exist")
                );
    }

    public void updateUser(UserDto userDto) {
        User user = getUserById(userDto.getId());
        if(!isEmailUnique(userDto.getEmail())){
            updateUserValues(user, userDto);
            userRepository.save(user);
        } else {
            throw new NotUniqueException("Email already exists");
        }
    }

    private User updateUserValues(User user, UserDto userDto) {
        if(userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }
        if(userDto.getFirstName() != null){
            user.setFirstName(userDto.getFirstName());
        }
        if(userDto.getLastName() != null){
            user.setLastName(userDto.getLastName());
        }
        if(userDto.getRole() != null){
            user.setRole(userDto.getRole());
        }
        return user;
    }

    private boolean isEmailUnique(String email) {
        return userRepository.countUserByEmail(email) == 0;
    }
}
