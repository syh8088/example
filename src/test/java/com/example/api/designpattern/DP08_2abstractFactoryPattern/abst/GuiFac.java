package com.example.api.designpattern.DP08_2abstractFactoryPattern.abst;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer802GuiFac")
public interface GuiFac {
    public Button createButton();
    public TextArea createTextArea();
}
