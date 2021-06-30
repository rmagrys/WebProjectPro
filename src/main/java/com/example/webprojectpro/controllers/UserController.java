package com.example.webprojectpro.controllers;

import com.example.webprojectpro.exceptions.NotFoundException;
import com.example.webprojectpro.models.dtos.UserDto;
import com.example.webprojectpro.converters.UserDtoConverter;
import com.example.webprojectpro.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path ="/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return UserDtoConverter.userListToDto(userService.getAllUsers());

    }

    @GetMapping(path = "/{id}")
    public UserDto getUserById(@PathVariable @NonNull final Long id){
        return UserDtoConverter
                .toDto(userService
                    .getUserById(id)
                    .orElseThrow(() -> new NotFoundException("User with id = " + id + " not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody final UserDto userDto){
        return UserDtoConverter
                .toDto(userService.saveNewUser(UserDtoConverter.toEntity(userDto)));
    }
}
