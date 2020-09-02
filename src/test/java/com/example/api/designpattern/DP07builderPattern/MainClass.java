package com.example.api.designpattern.DP07builderPattern;
/*
    복잡한 단계가 필요한 인스턴스 생성을 빌더 패턴을 통해서 구현할 수 있다.

    복잡한 단계를 거쳐야 생성되는 객체의 구현을 서브 클래스에게 넘겨주는 패턴

 */
public class MainClass {
    public static void main(String[] args) {

        ComputerFactory factory = new ComputerFactory();
        factory.setBlueprint(new LgGramBlueprint());
        //Computer computer = factory.makeAndGet();
        factory.make();
        Computer computer = factory.getComputer();

        //Computer computer = new Computer("i7", "16g", "256g ssd");
        System.out.println(computer.toString());
    }

}