package com.example.api.designpattern.DP14FacadePattern.system;

class HelpSystem3 {

    public HelpSystem3() {
        System.out.println("Call Constructor : " + getClass().getSimpleName());
    }

    public void process(){
        System.out.println("Call Process : "+ getClass().getSimpleName());
    }
}