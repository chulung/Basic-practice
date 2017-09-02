package com.chulung.dp.visitor.cart.domain;

import com.chulung.dp.visitor.cart.Visitor.AbstractCartVisitor;

/**
 * Created by chulung on 2017/8/28.
 */
public abstract class AbstractItem {
    private int id;
    private double price;
    private int num;
    private double amount;

    public AbstractItem(int id) {
        this.id = id;
    }

    public void accept(AbstractCartVisitor visitor) {
        visitor.visitDefault(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
