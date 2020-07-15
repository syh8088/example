package com.example.api.blogCode.java8_in_action;

import com.example.api.blogCode.java8_in_action.chap2.Apple;
import com.example.api.blogCode.java8_in_action.chap2.FruitInventory;
import com.example.api.blogCode.java8_in_action.chap2.java7.ApplePredicate;
import com.example.api.blogCode.java8_in_action.chap2.java7.AppleWeightPredicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class FruitInventoryTest {

    @Test
    public void 녹색사과와_빨간사과만_가져온다 () {
        List<Apple> inventory = new ArrayList<>();

        List<Apple> greenApples = FruitInventory.filterApplesByColor(inventory, "green");
        List<Apple> redApples = FruitInventory.filterApplesByColor(inventory, "red");

        System.out.println("greenApples : " + greenApples);
        System.out.println("redApples : " + redApples);
    }

    @Test
    public void java7이하에서_Predicate로_필터한다 () {
        List<Apple> inventory = new ArrayList<>();

        Apple compare = Apple.builder()
                .weight(150)
                .build();
        List<Apple> weightApples = FruitInventory.filterApples(inventory, new AppleWeightPredicate(), compare);

    }

    @Test
    public void java7이하에서_Predicate로_필터한다_익명클래스 () {
        List<Apple> inventory = new ArrayList<>();

        List<Apple> weightApples = FruitInventory.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple, Apple compare) {
                return apple.getWeight() > compare.getWeight();
            }
        }, Apple.builder()
                .weight(150)
                .build());
    }

}