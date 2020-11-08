package com.example.api.DI;

import org.apache.ibatis.type.Alias;

@Alias("DICar")
public class Car {
    private String name;

    public Car() {}

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
