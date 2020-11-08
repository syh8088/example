package com.example.api.designpattern.DP06prototypePattern;

import org.apache.ibatis.type.Alias;

/*
 * 프로토타입 패턴을 통해서 복잡한 인스턴스를 복사 할 수 있다.
 *
 * 종류가 너무 많아서 클래스로 정리되지 않는 경우
 * 클래스로부터 인스턴스 생성이 어려운 경우
 *
 * 일러스트레이터와 같은 그림 그리기 툴을 개발 중입니다. 어떤 모양(Shape) 그릴 수 있도록 하고 복사 붙여넣기 기능이 구현해주세요.
 */
@Alias("designatternVer6MainClass")
public class MainClass {


    public static void main(String[] args) throws CloneNotSupportedException {

        Circle circle1 = new Circle(1, 1, 3);

        Circle circle2 = circle1.copy();

        System.out.println(circle1.getX() + "," + circle1.getY() + "," + circle1.getR());
        System.out.println(circle2.getX() + "," + circle2.getY() + "," + circle2.getR());
    }
}