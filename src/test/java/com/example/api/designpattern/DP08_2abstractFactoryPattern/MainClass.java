package com.example.api.designpattern.DP08_2abstractFactoryPattern;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.Button;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.GuiFac;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.TextArea;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.concrete.FactoryInstance;

public class MainClass {

    public static void main(String[] args) {

        GuiFac fac = FactoryInstance.getGuiFac();

        Button button = fac.createButton();
        TextArea area = fac.createTextArea();

        button.click();
        System.out.println(area.getText());
        System.out.println(System.getProperty("os.name"));
    }
}
