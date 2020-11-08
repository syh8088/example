package com.example.api.designpattern.DP09BridgePattern;

import org.apache.ibatis.type.Alias;

/*
    브릿지 패턴에 대해서 이해
    어탭터 패턴과 브릿지 패턴을 연결하여 이해

    기능 부분과 구현 부분 분리

     구현부에서 추상층을 분리하여 각자 독립적으로 확장할 수 있게하여 결합도를 낮춘 패턴
     - 기능과 구현을 두 개의 별도 클래스로 구현한다.

 */
@Alias("designatternVer9MainClass")
public class MainClass {
    public static void main(String[] args) {
        PrintMorseCode code = new PrintMorseCode(new DefaultMCF());

        //code.g();code.a();code.r();code.a();code.r();
        code.g().a().r().a().m();

    }
}
