package com.example.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TestNew testNew2() {

        System.out.println("여기오니??????????????????????????????????????");

        return new TestNew();
    }
}