package com.example.webprojectpro.services;

import com.example.webprojectpro.exceptions.BadRequestException;
import com.example.webprojectpro.exceptions.NotFoundException;
import com.example.webprojectpro.exceptions.NotUniqueException;
import com.example.webprojectpro.models.dtos.LoginDto;
import com.example.webprojectpro.models.dtos.UserDto;
import com.example.webprojectpro.models.entities.User;
import com.example.webprojectpro.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveNewUser(User user) {
        if(isEmailUnique(user.getEmail())) {
            user.setCreateDate(LocalDate.now());
            user.setLastLogin(Timestamp.valueOf(LocalDateTime.now()));
            hashPassword(user);
            return userRepository.save(user);
        } else {
            throw new NotUniqueException("Email already exists");
        }
    }

    private void hashPassword(User user) {
        CharBuffer passwordBuffer = CharBuffer.wrap(user.getPassword());
        user.setPassword(passwordEncoder.encode(passwordBuffer).toCharArray());
    }

    private char[] hashPassword(char[] password){
        CharBuffer passwordBuffer = CharBuffer.wrap(password);
        return passwordEncoder.encode((passwordBuffer)).toCharArray();
    }

    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User with id = [" + id + "] does not exist")
                );
    }

    public User updateUserById(UserDto userDto, Long id) {
        User user = getUserById(id);
        if(isEmailUnique(userDto.getEmail())){
            updateUserValues(user, userDto);
            return userRepository.save(user);
        } else {
            throw new NotUniqueException("Email already exists");
        }
    }

    private void updateUserValues(User user, UserDto userDto) {
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
    }

    private boolean isEmailUnique(String email) {
        return userRepository.countUserByEmail(email) == 0;
    }

    public void updateLastLogin(User user) {
        user.setLastLogin(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
