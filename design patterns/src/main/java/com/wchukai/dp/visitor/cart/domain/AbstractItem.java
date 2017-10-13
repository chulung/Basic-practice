package com.wchukai.dp.visitor.cart.domain;

import com.wchukai.dp.visitor.cart.Visitor.AbstractCartVisitor;

/**
 * Created by chulung on 2017/8/28.
 */
public abstract class AbstractItem {
    private int id;
    private double price;
    private int num;
    private double amount;

    public AbstractItem(int id, int num) {
        this.id = id;
        this.num = num;
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
