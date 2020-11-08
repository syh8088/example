package com.example.api.designpattern.DP14FacadePattern.system;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer14HelpSystem3")
class HelpSystem3 {

    public HelpSystem3() {
        System.out.println("Call Constructor : " + getClass().getSimpleName());
    }

    public void process(){
        System.out.println("Call Process : "+ getClass().getSimpleName());
    }
}