package com.chulung.dp.visitor.cart.Visitor;

import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.GeneralItem;
import com.chulung.dp.visitor.cart.domain.PromotionalItem;

/**
 * Created by chulung on 2017/8/28.
 */
public abstract class AbstractCartVisitor implements CartVisitor {

    @Override
    public void visit(Cart cart) {
        for (AbstractItem item : cart.getItems()) {
            item.accept(this);
        }
    }

    @Override
    public void visitDefault(AbstractItem item) {
        //do nothing
    }

    @Override
    public void visitGeneralItem(GeneralItem generalItem) {
        visitDefault(generalItem);
    }

    @Override
    public void visitPromotionItem(PromotionalItem item) {
        visitDefault(item);
    }
}
