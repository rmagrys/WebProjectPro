package com.example.webprojectpro.config;

import com.example.webprojectpro.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response badRequestHandler(BadRequestException badRequestException){
        log.info(badRequestException.getMessage());
        return new Response(HttpStatus.BAD_REQUEST.value(), badRequestException.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response notFoundHandler(NotFoundException notFoundException){
        log.info(notFoundException.getMessage());
        return new Response(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
    }

    @ExceptionHandler(NotUniqueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response notUniqueHandler(NotUniqueException notUniqueException) {
        log.info(notUniqueException.getMessage());
        return new Response(HttpStatus.BAD_REQUEST.value(), notUniqueException.getMessage());
    }

    @ExceptionHandler(NotDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response notDeletedHandler(NotDeletedException notDeletedException){
        log.info(notDeletedException.getMessage());
        return new Response(HttpStatus.BAD_REQUEST.value(), notDeletedException.getMessage());
    }

    @ExceptionHandler(NotSavedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response notSavedHandler(NotSavedException notSavedException){
        log.info(notSavedException.getMessage());
        return new Response(HttpStatus.BAD_REQUEST.value(), notSavedException.getMessage());
    }

}
