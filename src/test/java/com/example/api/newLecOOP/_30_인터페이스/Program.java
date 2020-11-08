package com.example.api.newLecOOP._30_인터페이스;

import org.apache.ibatis.type.Alias;

@Alias("ver30Program")
public class Program {

    public static void main(String[] args) {
        A a = new A();
        a.print();
    }
}
