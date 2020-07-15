package com.example.api.blogCode.java8_in_action.chap2;

import com.example.api.blogCode.java8_in_action.chap2.java7.ApplePredicate;
import com.example.api.blogCode.java8_in_action.chap2.java8.AppleOnePredicate;

import java.util.ArrayList;
import java.util.List;

public class FruitInventory {

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean useColor){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {

            if( (useColor && apple.getColor().equals(color))
                    || (!useColor && apple.getWeight() > weight)) {

                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate, Apple compare){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(predicate.test(apple, compare)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, AppleOnePredicate predicate){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}