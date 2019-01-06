package com.example.api.DI;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

//@Service
public class OrderManager {
    //private HyundaiMaker maker;

    //@Inject
    //@Named("hyundai")
    private CarMaker maker;
   /* public OrderManager() {
        //maker = new HyundaiMaker();
        maker = new KiaMaker();
    }*/

    public void order() {
        Money money = new Money(1000);
        System.out.println("OrderManager.order : I made " + money.getAmount());
        System.out.println("OrderManager.order : I pated " + money.getAmount());

        Car car = maker.sell(money);
        System.out.println("OrderManager.order : I received " + car.getName());
    }

    public void setMaker(CarMaker maker) {
        this.maker = maker;
    }
}
