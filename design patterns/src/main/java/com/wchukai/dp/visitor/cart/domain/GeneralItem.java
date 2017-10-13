package com.wchukai.dp.visitor.cart.domain;

import com.wchukai.dp.visitor.cart.Visitor.AbstractCartVisitor;

/**
 * 普通商品
 * Created by chulung on 2017/8/28.
 */
public class GeneralItem extends AbstractItem {

    public GeneralItem(int id, int num) {
        super(id, num);
    }

    @Override
    public void accept(AbstractCartVisitor visitor) {
        visitor.visitGeneralItem(this);
    }
}
