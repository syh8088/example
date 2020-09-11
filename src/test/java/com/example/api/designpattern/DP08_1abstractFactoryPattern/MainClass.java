package com.example.api.designpattern.DP08_1abstractFactoryPattern;

import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.BikeFactory;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Body;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Wheel;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.sam.SamFactory;

/*
    관련 있는 객체의 생성을 가상화 할 수 있다.

    생성 부분의 가상화 / 관련있는 객체
 */
public class MainClass {
    public static void main(String[] args) {
        BikeFactory factory = new SamFactory();

        Body body = factory.createBody();
        Wheel wheel = factory.createWheel();

        System.out.println(body.getClass());
        System.out.println(wheel.getClass());
    }
}
