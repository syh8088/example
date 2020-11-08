package com.example.api.designpattern.DP09BridgePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer9DefaultMCF")
public class DefaultMCF implements MorseCodeFunction {
    @Override
    public void dot() {
        System.out.print(".");
    }

    @Override
    public void dash() {
        System.out.print("-");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}
