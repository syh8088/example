package com.example.api.designpattern.DP05singletonPattern;

/*
 * 객체 : 속성과 기능을 갖춘 것
 * 클래스 : 속성과 기능을 정의한 것
 * 인스턴스 : 속성과 기능을 사진 것 중 실제 하는 것
 *
 * 싱글톤 패턴을 통해서 하나의 인스턴스만 생성하도록 구현 할 수 있다.
 *
 */
public class MainClass {
    public static void main(String[] args) {
        SystemSpeaker speaker1 = SystemSpeaker.getInstance();
        SystemSpeaker speaker2 = SystemSpeaker.getInstance();

        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());

        speaker1.setVolume(11);

        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());

    }
}