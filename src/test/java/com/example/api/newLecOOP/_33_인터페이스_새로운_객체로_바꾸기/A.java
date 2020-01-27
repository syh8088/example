package com.example.api.newLecOOP._33_인터페이스_새로운_객체로_바꾸기;

public class A {
    private X x;

    public A() {
        //b = new B();
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public void print() {
        int total = x.total();
        System.out.printf("total is %d\n", total);
    }
}
