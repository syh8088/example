package com.example.api.designpattern.DP02adapterPattern;

/*
    연관성 없는 두 객체 묶어 사용하기
 */
public class MainClass {
    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl();

        System.out.println(adapter.twiceOf(100f));
        System.out.println(adapter.halfOf(80f));
    }
}
