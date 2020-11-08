package com.example.api.designpattern.DP01strategyPattern;

import org.apache.ibatis.type.Alias;

@Alias("designpatternVer1Sword")
public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("창 공격");
    }
}
