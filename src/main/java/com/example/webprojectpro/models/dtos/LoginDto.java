package com.example.webprojectpro.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @Max(255)
    @NotNull
    private String login;

    @Max(125)
    @NotNull
    private char[] password;

}
