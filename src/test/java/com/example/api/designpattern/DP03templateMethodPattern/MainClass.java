package com.example.api.designpattern.DP03templateMethodPattern;

import com.example.api.designpattern.DP03templateMethodPattern.externalLibrary.AbstGameConnectHelper;
import com.example.api.designpattern.DP03templateMethodPattern.externalLibrary.DefaultGameConnectHelper;

public class MainClass {

    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();

        helper.requestConnection("아이디 암호 등 접속 정보");
    }

}