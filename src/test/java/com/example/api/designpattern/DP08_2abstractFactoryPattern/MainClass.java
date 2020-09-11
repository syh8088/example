package com.example.api.designpattern.DP08_2abstractFactoryPattern;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.GuiFac;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.TextArea;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.concrete.FactoryInstance;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.linux.LinuxGuiFac;

public class MainClass {
    public static void main(String[] args) {

        GuiFac guiFac = FactoryInstance.getGuiFac();
        Button button = guiFac.createButton();
        TextArea textArea = guiFac.createTextArea();

        button.click();
        System.out.println(textArea.getText());
    }
}
