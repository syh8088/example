package com.example.api.blogCode.java8_in_action.chap2.java7;

import com.example.api.blogCode.java8_in_action.chap2.Apple;

public interface ApplePredicate {
    boolean test(Apple apple, Apple compare);
}