package com.example.api.designpattern.DP01strategyPattern;

public class GameCharacter {

    // 접근점
    Weapon weapon;

    // 교환 가능
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {

        if(weapon == null) {
            System.out.println("손 공격");
        } else weapon.attack();  // 델리게이트
    }
}
