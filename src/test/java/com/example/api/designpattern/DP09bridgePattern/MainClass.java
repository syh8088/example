package com.example.api.designpattern.DP09bridgePattern;

/*
    브릿지 패턴에 대해서 이해
    어탭터 패턴과 브릿지 패턴을 연결하여 이해

    기능 부분과 구현 부분 분리

 */
public class MainClass {
    public static void main(String[] args) {
        PrintMorseCode code = new PrintMorseCode(new DefaultMCF());

        //code.g();code.a();code.r();code.a();code.r();
        code.g().a().r().a().m();

    }
}
