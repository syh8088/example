package com.example.api.designpattern.DP08_2abstractFactoryPattern.concrete;

import com.example.api.designpattern.DP08_2abstractFactoryPattern.abst.GuiFac;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.linux.LinuxGuiFac;
import com.example.api.designpattern.DP08_2abstractFactoryPattern.mac.MacGuiFac;

public class FactoryInstance {

    public static GuiFac getGuiFac() {

        switch (getOsCode()) {
            case 0: return new MacGuiFac();
            case 1: return new LinuxGuiFac();
        }

        return null;

    }

    private static int getOsCode() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            return 0;
        } else return 1;
    }
}
