package com.example.api.newLecOOP._32_인터페이스_개체_결합을_위한_인터페이스_구현하기;

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
