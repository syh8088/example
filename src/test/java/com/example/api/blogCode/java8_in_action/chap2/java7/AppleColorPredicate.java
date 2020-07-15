package com.example.api.blogCode.java8_in_action.chap2.java7;

import com.example.api.blogCode.java8_in_action.chap2.Apple;

public class AppleColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple, Apple compare) {
        return apple.getColor().equals(compare.getColor());
    }
}