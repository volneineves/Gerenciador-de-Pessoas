package com.volnei.gerenciadordepessoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<StandardError> notFound(NotFound e) {
        StandardError error = new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException .class)
    public ResponseEntity<StandardError> beanValidation(MethodArgumentNotValidException  exception) {
        String validationErro = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        StandardError error = new StandardError(validationErro, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
