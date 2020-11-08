package com.example.api.designpattern.DP09BridgePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer9PrintMorseCode")
public class PrintMorseCode extends MorseCode {

    PrintMorseCode(MorseCodeFunction morseCodeFunction) {
        super(morseCodeFunction);
    }

    public PrintMorseCode g() {
        dash();dash();dot();space();

        return this;
    }

    public PrintMorseCode a() {
        dot();dash();space();

        return this;
    }

    public PrintMorseCode r() {
        dot();dash();dot();space();

        return this;
    }

    public PrintMorseCode m() {
        dash();dash();space();

        return this;
    }
}
