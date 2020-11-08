package com.example.api.DI;

import org.apache.ibatis.type.Alias;

@Alias("DIMoney")
public class Money {
    private int amount;

    public Money() {}

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
