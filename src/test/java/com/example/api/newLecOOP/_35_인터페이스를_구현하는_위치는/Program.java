package com.example.api.newLecOOP._35_인터페이스를_구현하는_위치는;

import org.apache.ibatis.type.Alias;

import java.awt.event.WindowListener;

@Alias("ver35Program")
public class Program {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        //WindowListener listener = new GameWindowListener();
        //frame.addWindowListener(listener);
        //frame.setVisible(true);
    }
}
