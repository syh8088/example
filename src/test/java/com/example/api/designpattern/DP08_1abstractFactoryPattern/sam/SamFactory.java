package com.example.api.designpattern.DP08_1abstractFactoryPattern.sam;

import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.BikeFactory;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Body;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Wheel;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer801SamFactory")
public class SamFactory implements BikeFactory {

    @Override
    public Body createBody() {
        return new SamBody();
    }

    @Override
    public Wheel createWheel() {
        return new SamWheel();
    }
}
