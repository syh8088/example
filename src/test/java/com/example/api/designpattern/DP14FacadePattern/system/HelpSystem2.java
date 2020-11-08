package com.example.api.designpattern.DP14FacadePattern.system;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer14HelpSystem2")
class HelpSystem2 {

    public HelpSystem2() {
        System.out.println("Call Constructor : " + getClass().getSimpleName());
    }

    public void process(){
        System.out.println("Call Process : "+ getClass().getSimpleName());
    }
}