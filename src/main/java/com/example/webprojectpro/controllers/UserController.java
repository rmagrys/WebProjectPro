package com.example.webprojectpro.controllers;

import com.example.webprojectpro.converters.UserDtoConverter;
import com.example.webprojectpro.models.dtos.LoginDto;
import com.example.webprojectpro.models.dtos.UserDto;
import com.example.webprojectpro.services.UserService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(path = "/users")
@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/login")
    @PreAuthorize("permitAll()")
    public UserDto loginUser(@RequestBody @Valid final LoginDto loginDto) {
        return UserDtoConverter.toDtoAllData(userService.loginUser(loginDto));
    }


    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDto> getAllUsers() {
        return UserDtoConverter.listToDto(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserDto getUserById(@PathVariable @NotNull final Long id) {
        return UserDtoConverter
                .toDto(userService.getUserById(id));
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addUser(@RequestBody @Valid final UserDto userDto) {
        return userService.saveNewUser(UserDtoConverter.toEntity(userDto)).getId();
    }

    @PatchMapping(path = "/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Long updateUserById(@RequestBody @Valid final UserDto userDto, @PathVariable @NotNull final Long id){
       return userService.updateUserById(userDto, id).getId();
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable @NotNull final Long id){
        userService.deleteUserById(id);
    }
}
