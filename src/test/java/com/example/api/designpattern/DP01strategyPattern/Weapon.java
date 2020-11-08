package com.example.api.designpattern.DP01strategyPattern;

import org.apache.ibatis.type.Alias;

@Alias("designpatternVer1Weapon")
public interface Weapon {
    public void attack();
}
