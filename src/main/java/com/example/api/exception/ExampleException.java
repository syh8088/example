package com.example.api.exception;

import lombok.Getter;

import java.util.HashMap;
@Getter
public class ExampleException extends Exception {

    private final String code;
    private final HashMap data;

    /**
     *
     *
     * @param code
     * @param message
     */
    public ExampleException(String code, String message) {

        super(message);
        this.code = code;
        this.data = null;
    }

}
