package com.example.api.designpattern.DP08_1abstractFactoryPattern;

import com.example.api.designpattern.DP08_1abstractFactoryPattern.Sam.SamFactory;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.BikeFactory;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Body;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Wheel;

public class MainClass {

    public static void main(String[] args) {
        BikeFactory factory = new SamFactory();
        Body body = factory.createBody();
        Wheel wheel = factory.creatWheel();

    }
}
