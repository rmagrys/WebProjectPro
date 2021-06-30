package com.example.webprojectpro.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response {

    private final int code;
    private final String message;
}
