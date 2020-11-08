package com.example.api.designpattern.DP10CompositePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer10Component")
abstract public class Component {

    public Component(String name) {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}