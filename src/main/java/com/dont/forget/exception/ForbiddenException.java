package com.dont.forget.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException{

    private String warning;

    public ForbiddenException() {

    }

    public ForbiddenException(String warning) {
        super(warning);
        this.warning = warning;
    }

    public String getWarning() {
        return warning;
    }

}
