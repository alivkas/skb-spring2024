package com.example.skbspring2024.web.errors;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class CommonAdvice {

    private final static String VALIDATION_ERROR = "validation_error";

    @ExceptionHandler
    public ErrorResponse handleNotFoundException(NotFoundError ex) {
        return new ErrorResponse(ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(x -> new ErrorResponse(x.getDefaultMessage(), VALIDATION_ERROR, x.getCode())).toList();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<ErrorResponse> handleConstraints(ConstraintViolationException ex) {
        return ex.getConstraintViolations()
                .stream()
                .map(x -> new ErrorResponse(x.getMessage(), VALIDATION_ERROR, x.getPropertyPath().toString())).toList();
    }
}
