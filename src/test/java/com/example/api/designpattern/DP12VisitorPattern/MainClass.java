package com.example.api.designpattern.DP12VisitorPattern;

import com.example.api.designpattern.DP12VisitorPattern.concrete.VisitableA;
import com.example.api.designpattern.DP12VisitorPattern.concrete.VisitorA;
import com.example.api.designpattern.DP12VisitorPattern.contract.Visitable;

import java.util.ArrayList;

/*
    방문자 패턴을 이용하여 객체에서 처리를 분리해서 사용할 수 있다.
 */
public class MainClass {
    public static void main(String[] args) {

        ArrayList<Visitable> as = new ArrayList<>();

        as.add(new VisitableA(1));
        as.add(new VisitableA(2));
        as.add(new VisitableA(3));
        as.add(new VisitableA(4));
        as.add(new VisitableA(5));

        VisitorA visitor = new VisitorA();
        for (Visitable va : as) {
            va.accept(visitor);
        }
        System.out.println(visitor.getNumber());
    }
}
