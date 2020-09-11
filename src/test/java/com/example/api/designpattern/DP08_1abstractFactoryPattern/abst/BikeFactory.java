package com.example.api.designpattern.DP08_1abstractFactoryPattern.abst;

public interface BikeFactory {
    public Body createBody();
    public Wheel createWheel();
}
