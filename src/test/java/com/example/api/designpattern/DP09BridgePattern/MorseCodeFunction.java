package com.example.api.designpattern.DP09BridgePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer9MorseCodeFunction")
public interface MorseCodeFunction {
    public void dot();
    public void dash();
    public void space();
}
