package com.example.api.newLecOOP._34_일부_기능을_분리하는_인터페이스;

import java.awt.*;

public class GameFrame extends Frame {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawRect(100, 100, 200, 100);
    }
}
