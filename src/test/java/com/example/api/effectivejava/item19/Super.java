package com.example.api.effectivejava.item19;

// 재정의 가능 메서드를 호출하는 생성자 - 따라 하지 말 것! (115쪽)
public class Super {
    // 잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.
    public Super() {
        System.out.println("Super");
        System.out.println("start!~~~");
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Super >> overrideMe()");
    }
}
