package com.example.api.designpattern.DP09BridgePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer9MorseCode")
public class MorseCode {

    private MorseCodeFunction morseCodeFunction;

    MorseCode(MorseCodeFunction morseCodeFunction) {
        this.morseCodeFunction = morseCodeFunction;
    }

    public void dot() {
        // 위임하다.
        morseCodeFunction.dot();

      //  System.out.print(".");
    }

    public void dash() {
        morseCodeFunction.dash();

      //  System.out.print("-");
    }

    public void space() {
        morseCodeFunction.space();

       // System.out.print(" ");
    }
}
