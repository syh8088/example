package com.example.api.blogCode.java8_in_action.chap3;

import com.example.api.blogCode.java8_in_action.chap2.Apple;

import java.util.Comparator;

public class LambdaSample {

    public void sample7() {
        Comparator<Apple> weightComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        };
    }

    public void sample8() {
        Comparator<Apple> weightComparator = (o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight());
    }
}
