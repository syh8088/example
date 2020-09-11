package com.example.api.designpattern.DP08_2abstractFactoryPattern.linux;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;

public class LinuxButton implements Button {
    @Override
    public void click() {
        System.out.println("리눅스 버튼");
    }
}
