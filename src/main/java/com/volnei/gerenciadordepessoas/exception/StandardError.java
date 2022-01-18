package com.volnei.gerenciadordepessoas.exception;

import java.sql.Timestamp;

public class StandardError {

    private final String message;
    private final Integer status;
    private final Long timeStamp = System.currentTimeMillis();

    public StandardError(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}
