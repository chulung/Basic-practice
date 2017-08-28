package com.chulung.dp.visitor.prototype;

/**
 * Created by chulung on 2017/8/28.
 */
public class ElementB extends Element {
    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.visitElementB(this);
    }
}
