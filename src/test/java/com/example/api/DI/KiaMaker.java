package com.example.api.DI;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Alias("DIKiaMaker")
//@Component("kia")
public class KiaMaker implements CarMaker {

    @Override
    public Car sell(Money money) {
        System.out.println("기아 : I got " + money.getAmount());

        Car car = new Car("K5");
        System.out.println("기아 : I made " + car.getName() );
        System.out.println("기아 : i sold " + car
                .getName());

        return car;
    }
}
