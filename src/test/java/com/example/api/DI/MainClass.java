package com.example.api.DI;

public class MainClass {
    public static void main(String[] args) {
      //  OrderManager manager = new OrderManager();
      //  manager.order();

        CarMaker maker = new HyundaiMaker();
        OrderManager manager = new OrderManager();
        manager.setMaker(maker);
        manager.order();

    }
}