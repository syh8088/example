package com.example.api.designpattern.DP08_2abstractFactoryPattern.mac;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.TextArea;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer802MacTextArea")
public class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "맥 텐스트 에어리어";
    }
}
