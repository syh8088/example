package com.example.api.designpattern.DP08_2abstractFactoryPattern.linux;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.GuiFac;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.TextArea;

public class LinuxGuiFac implements GuiFac {

    @Override
    public Button createButton() {
        //
        return new LinuxButton();
    }

    @Override
    public TextArea createTextArea() {
        return new LinuxTextArea();
    }
}
