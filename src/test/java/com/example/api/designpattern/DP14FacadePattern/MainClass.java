package com.example.api.designpattern.DP14FacadePattern;

import com.example.api.designpattern.DP14FacadePattern.system.Facade;

/*
    복잡한 과정을 간단하게 제공

    복잡한 과정을 간단하게 표현하는 퍼서드 패턴을 이해한다.

    키워드 : 단순한 접근

 */
public class MainClass {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.process();
    }
}
