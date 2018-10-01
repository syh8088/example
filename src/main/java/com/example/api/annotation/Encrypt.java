package com.example.api.annotation;

import com.example.api.model.enums.EncryptType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Encrypt {
    EncryptType type() default EncryptType.PASSWORD;
}
