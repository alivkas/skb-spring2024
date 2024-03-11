package com.example.skbspring2024.web.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ErrorResponse handleNotFound(NotFoundException ex) {
        return new ErrorResponse(ex.getCode(), ex.getLocalizedMessage());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatusCode status,
                                                                         WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Bad Gateway");
    }
}
