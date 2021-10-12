package com.company.calendarmanagementsystem.handler;

import com.company.calendarmanagementsystem.exception.UserNotFound;
import com.company.calendarmanagementsystem.exception.UsernameIsNotUnique;
import com.company.calendarmanagementsystem.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerUnit {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFound.class)
    public ExceptionResponse handleOperatorNotFoundException(UserNotFound ex){
        return ex.getExceptionResponse();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameIsNotUnique.class)
    public ExceptionResponse handleUsernameIsNotUniqueException(UsernameIsNotUnique ex){
        return ex.getExceptionResponse();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleUnexpectedError(Exception ex){
        return new ExceptionResponse(ex.getMessage(),500);
    }
}
