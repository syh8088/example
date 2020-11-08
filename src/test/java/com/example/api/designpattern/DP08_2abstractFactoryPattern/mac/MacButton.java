package com.example.api.designpattern.DP08_2abstractFactoryPattern.mac;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer802MacButton")
public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("맥 버튼");
    }
}
