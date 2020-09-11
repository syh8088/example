package com.example.api.designpattern.DP08_2abstractFactoryPattern.mac;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("맥 버튼");
    }
}
