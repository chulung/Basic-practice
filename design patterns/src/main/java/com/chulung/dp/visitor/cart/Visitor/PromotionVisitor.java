package com.chulung.dp.visitor.cart.Visitor;

import com.chulung.dp.visitor.cart.domain.PromotionalItem;
import com.chulung.dp.visitor.cart.service.PromotionService;
import com.chulung.dp.visitor.cart.service.impl.PromotionServiceImpl;

/**
 * Created by chulung on 2017/8/28.
 */
public class PromotionVisitor extends AbstractCartVisitor {

    private PromotionService promotionService=new PromotionServiceImpl();

    @Override
    public void visitPromotionItem(PromotionalItem item) {
        double discount = promotionService.queryDiscountByItemId(item.getId());
        item.setDiscount(discount);
    }
}
