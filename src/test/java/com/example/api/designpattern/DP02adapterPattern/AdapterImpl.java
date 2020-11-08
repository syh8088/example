package com.example.api.designpattern.DP02adapterPattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer2AdapterImpl")
public class AdapterImpl implements Adapter {

    // Math math;
    @Override
    public Float twiceOf(Float f) {
        return Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        return (float) Math.half(f.doubleValue());
    }
}
