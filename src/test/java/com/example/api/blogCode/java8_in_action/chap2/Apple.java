package com.example.api.blogCode.java8_in_action.chap2;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Apple {
    private String color;
    private int weight;

    @Builder
    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}