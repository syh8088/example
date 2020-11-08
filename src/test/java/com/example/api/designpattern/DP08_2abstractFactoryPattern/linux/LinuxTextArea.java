package com.example.api.designpattern.DP08_2abstractFactoryPattern.linux;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.TextArea;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer802LinuxTextArea")
public class LinuxTextArea implements TextArea {
    @Override
    public String getText() {
        return "리눅스 텐스트 에어리어";
    }
}
