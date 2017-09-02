package com.chulung.dp.visitor.cart.Visitor;

import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.GeneralItem;
import com.chulung.dp.visitor.cart.domain.PromotionalItem;

/**
 * Created by chulung on 2017/9/2.
 */
public interface CartVisitor {
    void visit(Cart cart);

    void visitDefault(AbstractItem item);

    void visitGeneralItem(GeneralItem generalItem);

    void visitPromotionItem(PromotionalItem item);
}
