package com.example.api.designpattern.DP08_1abstractFactoryPattern.abst;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer801BikeFactory")
public interface BikeFactory {
    public Body createBody();
    public Wheel createWheel();
}
