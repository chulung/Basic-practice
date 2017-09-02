package com.chulung.dp.visitor.cart.domain;

import com.chulung.dp.visitor.cart.Visitor.AbstractCartVisitor;

/**
 * Created by chulung on 2017/8/28.
 */
public class PromotionalItem extends AbstractItem {
    private double discount;

    public PromotionalItem(int id) {
        super(id);
    }

    @Override
    public void accept(AbstractCartVisitor visitor) {
        visitor.visitPromotionItem(this);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
