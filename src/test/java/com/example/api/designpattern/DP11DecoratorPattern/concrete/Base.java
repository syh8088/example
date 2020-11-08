package com.example.api.designpattern.DP11DecoratorPattern.concrete;

import com.example.api.designpattern.DP11DecoratorPattern.abst.IBeverage;
import org.apache.ibatis.type.Alias;

/**
 * <h2><b>Role : </b>ConcreteComponent</h2>
 *  <p>
 *  Component의 실질적인 인스턴스의 부분이며, 책임의 주체입니다.
 *  </p>
 * @author garam park
 *
 */
@Alias("designatternVer11Base")
public class Base implements IBeverage {

    @Override
    public int getTotalPrice() {
        return 0;
    }

}
