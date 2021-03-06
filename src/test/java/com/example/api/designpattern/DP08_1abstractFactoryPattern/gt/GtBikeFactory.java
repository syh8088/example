package com.example.api.designpattern.DP08_1abstractFactoryPattern.gt;

import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.BikeFactory;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Body;
import com.example.api.designpattern.DP08_1abstractFactoryPattern.abst.Wheel;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer801GtBikeFactory")
public class GtBikeFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new GtBody();
    }

    @Override
    public Wheel createWheel() {
        return new GtWheel();
    }
}
