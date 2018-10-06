package com.example.api.designpattern.DP01strategyPattern;

public class MainClass {

    public static void main(String[] args) {
        Ainterface ainterface = new AinterfaceImpl();

        // 통로
        ainterface.funcA();

        AObj aObj = new AObj();
        aObj.funcAA();

        GameCharacter character = new GameCharacter();
        character.attack();

        character.setWeapon(new Knife());
        character.attack();

        character.setWeapon(new Sword());
        character.attack();
    }
}
