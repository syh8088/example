package com.example.api.DI;

import org.springframework.stereotype.Component;

//@Component("hyundai")
public class HyundaiMaker implements CarMaker {

    @Override
    public Car sell(Money money) {
        System.out.println("현대 : I got " + money.getAmount());

        Car car = new Car("Sonata");
        System.out.println("현대 : I made " + car.getName() );
        System.out.println("현대 : i sold " + car
        .getName());

        return car;
    }
}
