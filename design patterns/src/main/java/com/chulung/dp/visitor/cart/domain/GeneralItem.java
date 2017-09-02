package com.chulung.dp.visitor.cart.domain;

import com.chulung.dp.visitor.cart.Visitor.AbstractCartVisitor;

/**
 * Created by chulung on 2017/8/28.
 */
public class GeneralItem extends AbstractItem {

    public GeneralItem(int id) {
        super(id);
    }

    @Override
    public void accept(AbstractCartVisitor visitor) {
        visitor.visitGeneralItem(this);
    }
}
