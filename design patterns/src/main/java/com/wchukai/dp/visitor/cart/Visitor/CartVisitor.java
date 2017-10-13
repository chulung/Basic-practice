package com.wchukai.dp.visitor.cart.Visitor;

import com.wchukai.dp.visitor.cart.domain.AbstractItem;
import com.wchukai.dp.visitor.cart.domain.Cart;
import com.wchukai.dp.visitor.cart.domain.GeneralItem;

/**
 * Created by chulung on 2017/9/2.
 */
public interface CartVisitor {
    void visit(Cart cart);

    void visitDefault(AbstractItem item);

    void visitGeneralItem(GeneralItem generalItem);

}
