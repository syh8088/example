package com.example.api.newLecOOP._32_인터페이스_개체_결합을_위한_인터페이스_구현하기;

import org.apache.ibatis.type.Alias;

@Alias("ver32Program")
public class Program {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setX(b);

        a.print();
    }
}
