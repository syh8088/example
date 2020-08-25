package com.example.api.designpattern.DP01strategyPattern;

public class Knife implements Weapon {

    @Override
    public void attack() {
        System.out.println("검 공격");
    }
}
