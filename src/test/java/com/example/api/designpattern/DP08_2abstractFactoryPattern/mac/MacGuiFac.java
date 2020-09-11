package com.example.api.designpattern.DP08_2abstractFactoryPattern.mac;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.GuiFac;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.TextArea;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.linux.LinuxButton;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.linux.LinuxTextArea;

public class MacGuiFac implements GuiFac {

    @Override
    public Button createButton() {
        //
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}
