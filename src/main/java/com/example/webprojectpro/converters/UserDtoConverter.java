package com.example.webprojectpro.converters;

import com.example.webprojectpro.models.dtos.UserDto;
import com.example.webprojectpro.models.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoConverter {

    public static UserDto toDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .semester(user.getSemester())
                .learningGroup(user.getLearningGroup())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(null)
                .createDate(user.getCreateDate())
                .lastLogin(user.getLastLogin())
                .role(user.getRole())
                .build();
    }

    public static User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .semester(userDto.getSemester())
                .learningGroup(userDto.getLearningGroup())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .createDate(userDto.getCreateDate())
                .lastLogin(userDto.getLastLogin())
                .role(userDto.getRole())
                .build();
    }

    public static UserDto toDtoAllData(User user){
       return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .semester(user.getSemester())
                .learningGroup(user.getLearningGroup())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(null)
                .createDate(user.getCreateDate())
                .lastLogin(user.getLastLogin())
                .role(user.getRole())
                .UserProjectsDto(user
                        .getUserProjects()
                        .stream()
                        .map(UserProjectDtoConverter::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static List<UserDto> listToDto(List<User> userList) {
        return userList
                .stream()
                .map(UserDtoConverter::toDto)
                .collect(Collectors.toList());

    }

    public static List<User> listToEntity(List<UserDto> userDtos) {
        return userDtos
                .stream()
                .map(UserDtoConverter::toEntity)
                .collect(Collectors.toList());
    }
}
