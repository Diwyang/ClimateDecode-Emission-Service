package com.climate.decode.event.emissions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmissionNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmissionNotFoundException(String message){
        super(message);
    }
}
