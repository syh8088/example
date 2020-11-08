package com.example.api.designpattern.DP01strategyPattern;

import org.apache.ibatis.type.Alias;

@Alias("designpatternVer1Knife")
public class Knife implements Weapon {

    @Override
    public void attack() {
        System.out.println("검 공격");
    }
}
