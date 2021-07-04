package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.UserDtoConverter;
import com.example.webprojectpro.models.dtos.UserDto;
import com.example.webprojectpro.models.entities.User;
import com.example.webprojectpro.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return UserDtoConverter.listToDto(userService.getAllUsers());

    }

    @GetMapping(path = "/{id}")
    public UserDto getUserById(@PathVariable @NonNull final Long id) {
        return UserDtoConverter
                .toDto(userService.getUserById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long addUser(@RequestBody final UserDto userDto) {
        User user = userService.saveNewUser(UserDtoConverter.toEntity(userDto));
        return user.getId();
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody final UserDto userDto){
        userService.updateUser(userDto);
    }
}
