package com.example.api.error.exception;

import com.example.api.config.handler.CustomMessageHandler;
import com.example.api.error.errorCode.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MemberException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public MemberException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
    }

    @Override
    public String getMessage() {
        return message;
    }
}
