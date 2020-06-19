package com.example.api.thread;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator(0);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Thread thread1 = new Thread(() -> {
           for (int i = 0; i < 100000; i++) {
               set1.add(calculator.getNextIndex());
           }
        });

        Thread thread2 = new Thread(() -> {
           for (int i = 0; i < 100000; i++) {
               set2.add(calculator.getNextIndex());
           }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(10000);

        System.out.println(set1.size());
        System.out.println(set2.size());
        System.out.println(calculator.getIndex());

    }
}
