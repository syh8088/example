package com.example.api.designpattern.DP11DecoratorPattern;

import com.example.api.designpattern.DP11DecoratorPattern.abst.IBeverage;
import com.example.api.designpattern.DP11DecoratorPattern.concrete.Base;
import com.example.api.designpattern.DP11DecoratorPattern.concrete.Espresso;
import com.example.api.designpattern.DP11DecoratorPattern.concrete.Milk;

import java.util.Scanner;

/*
    동적으로 책임 추가가 필요할 때 데코레이터 패턴을 사용할 수 있다.

    키워드 : 동적, 책임 추가


 */
public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // base
        IBeverage beverage = new Base();
        boolean done = false;
        while (!done) {
            System.out.println("음료 현재 가격 : "+beverage.getTotalPrice());
            System.out.print("선택 : 1:샷 추가 / 2:우유 추가");
            switch (sc.nextInt()) {
                case 0: done = true;
                    break;
                case 1:
                    beverage = new Espresso(beverage);
                    break;
                case 2:
                    beverage = new Milk(beverage);
                    break;
            }
        }

        System.out.println("음료 가격 : "+beverage.getTotalPrice());
        sc.close();
    }

}