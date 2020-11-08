package com.example.api.designpattern.DP07builderPattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer7LgGramBlueprint")
public class LgGramBlueprint extends BluePrint {

    private Computer computer;

    public LgGramBlueprint() {
        computer = new Computer("default", "default", "default");
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7");
    }

    @Override
    public void setRam() {
        computer.setRam("16g");
    }

    @Override
    public void setStorage() {
        computer.setStorage("256g ssd");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}