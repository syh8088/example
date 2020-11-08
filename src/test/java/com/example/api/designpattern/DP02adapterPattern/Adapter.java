package com.example.api.designpattern.DP02adapterPattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer2Adapter")
public interface Adapter {
    // 원하는 기능
    public Float twiceOf(Float f);
    // 원하는 기능
    public Float halfOf(Float f);
}