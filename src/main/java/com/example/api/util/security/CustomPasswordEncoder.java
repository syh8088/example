package com.example.api.util.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    private PasswordEncoding passwordEncoding;

    public CustomPasswordEncoder() {
        SHAPasswordEncoder shaPasswordEncoder = new SHAPasswordEncoder(512);
        shaPasswordEncoder.setEncodeHashAsBase64(true);
        this.passwordEncoding = new PasswordEncoding(shaPasswordEncoder);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoding.encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoding.matches(rawPassword, encodedPassword);
    }
}
