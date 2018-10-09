package com.example.api.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomMessageHandler {
    // 스프링 꺼
    // private final MessageSource messageSource;

    // 내 꺼(static!)
    private static MessageSource staticMessageSource;

    @Autowired
    public CustomMessageHandler(MessageSource messageSource) {
        staticMessageSource = messageSource;
    }

//    @PostConstruct
//    public void newInstance() {
//        staticMessageSource = staticMessageSource;
//    }

    public static String getMessage(String code) {
        return staticMessageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}
