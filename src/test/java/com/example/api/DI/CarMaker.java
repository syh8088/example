package com.example.api.DI;

import org.apache.ibatis.type.Alias;

@Alias("DICarMaker")
public interface CarMaker {
    public Car sell(Money money);
}
