package com.example.api.newLecOOP._20_IS_A_상속_쉬어가기;

import org.apache.ibatis.type.Alias;

@Alias("ver20Program")
public class Program {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setVisible(true);
    }
}
