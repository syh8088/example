package com.example.api.designpattern.DP04factoryMethodPattern.concrete;

import com.example.api.designpattern.DP04factoryMethodPattern.framework.Item;

public class HpPotion implements Item {

    @Override
    public void use() {
        System.out.println("체력 회복!");
    }
}
