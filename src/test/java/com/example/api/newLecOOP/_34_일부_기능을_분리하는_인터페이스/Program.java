package com.example.api.newLecOOP._34_일부_기능을_분리하는_인터페이스;

import java.awt.event.WindowListener;

public class Program {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        WindowListener listener = new GameWindowListener();
        frame.addWindowListener(listener);
        frame.setVisible(true);
    }
}
