package com.chulung.dp.visitor.cart.domain;

import java.util.List;

/**
 * Created by chulung on 2017/9/2.
 */
public class Cart {
    List<AbstractItem> items;
    private double amount;

    public List<AbstractItem> getItems() {
        return items;
    }

    public void setItems(List<AbstractItem> items) {
        this.items = items;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
