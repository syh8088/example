package com.example.api.newLecOOP._33_인터페이스_새로운_객체로_바꾸기;

import org.apache.ibatis.type.Alias;

@Alias("ver33B")
public class B implements X {

    public int total() {
        return 30;
    }
}
