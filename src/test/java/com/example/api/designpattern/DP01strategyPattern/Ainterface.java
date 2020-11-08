package com.example.api.designpattern.DP01strategyPattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer1Ainterface")
public interface Ainterface {
    // 기능에 선언
    public void funcA();
}