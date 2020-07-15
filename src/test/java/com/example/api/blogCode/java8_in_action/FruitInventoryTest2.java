package com.example.api.blogCode.java8_in_action;

import com.example.api.blogCode.java8_in_action.chap2.Apple;
import com.example.api.blogCode.java8_in_action.chap2.FruitInventory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class FruitInventoryTest2 {

    @Test
    public void 익명클래스 () {
        List<Apple> inventory = new ArrayList<>();

        FruitInventory.filterApples(inventory,
                (apple, compare) -> apple.getWeight() > compare.getWeight(),
                Apple.builder()
                        .weight(150)
                        .build());
    }

    @Test
    public void 스트림API () {
        List<Apple> inventory = new ArrayList<>();
        Apple compare = new Apple();

        List<Apple> weightApples = inventory.stream()
                .filter(apple -> apple.getWeight() > compare.getWeight())
                .collect(Collectors.toList());
    }
}