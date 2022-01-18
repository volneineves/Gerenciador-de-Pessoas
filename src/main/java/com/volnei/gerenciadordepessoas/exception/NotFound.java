package com.volnei.gerenciadordepessoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound  extends RuntimeException{

    public NotFound(String message, Long id) {
        super(message + " " + id);
    }
}
