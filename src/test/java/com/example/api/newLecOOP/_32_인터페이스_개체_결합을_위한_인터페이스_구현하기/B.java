package com.example.api.newLecOOP._32_인터페이스_개체_결합을_위한_인터페이스_구현하기;

import org.apache.ibatis.type.Alias;

@Alias("ver32B")
public class B implements X {

    public int total() {
        return 30;
    }
}
