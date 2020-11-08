package com.example.api.designpattern.DP01strategyPattern;

import org.apache.ibatis.type.Alias;

@Alias("designpatternVer1AObj")
public class AObj {

    Ainterface ainterface;

    public AObj() {
        ainterface = new AinterfaceImpl();
    }

    public void funcAA() {

        // 위임하다(델리게이트)
        ainterface.funcA();
        ainterface.funcA();
    }
}
