package com.example.api.newLecOOP._35_인터페이스를_구현하는_위치는;

import org.apache.ibatis.type.Alias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@Alias("ver35GameFrame")
public class GameFrame extends Frame implements WindowListener {

    public GameFrame() {
        addWindowListener(this);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawRect(100, 100, 200, 100);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(this, "Good Bye~");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
