package com.example.api.designpattern.DP04factoryMethodPattern.concrete;

import com.example.api.designpattern.DP04factoryMethodPattern.framework.Item;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer4HpPotion")
public class HpPotion implements Item {

    @Override
    public void use() {
        System.out.println("체력 회복!");
    }
}
