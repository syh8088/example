package com.example.api.designpattern.DP01strategyPattern;

public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("창 공격");
    }
}
