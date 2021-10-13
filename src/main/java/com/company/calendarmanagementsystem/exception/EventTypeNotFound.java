package com.company.calendarmanagementsystem.exception;

import com.company.calendarmanagementsystem.model.ExceptionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventTypeNotFound extends RuntimeException {
    private final ExceptionResponse exceptionResponse;
}
