package com.example.api.designpattern.DP01strategyPattern;

import org.apache.ibatis.type.Alias;

@Alias("designpatternVer1AinterfaceImpl")
public class AinterfaceImpl implements Ainterface {

    @Override
    public void funcA() {
        System.out.println("AAA");
    }
}
