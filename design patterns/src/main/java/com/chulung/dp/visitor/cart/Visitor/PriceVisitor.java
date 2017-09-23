package com.chulung.dp.visitor.cart.Visitor;

import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.PromotionalItem;
import com.chulung.dp.visitor.cart.service.PriceService;
import com.chulung.dp.visitor.cart.service.impl.PriceServiceImpl;

/**
 * Created by chulung on 2017/8/28.
 */
public class PriceVisitor extends AbstractCartVisitor {
    private double amount;
    private PriceService priceService = new PriceServiceImpl();

    @Override
    public void visit(Cart cart) {
        super.visit(cart);
        amount = cart.getItems().stream().mapToDouble(AbstractItem::getAmount).sum();
    }

    /**
     * 普通商品价格
     *
     * @param item
     */
    @Override
    public void visitDefault(AbstractItem item) {
        refreshPrice(item);
        item.setAmount(item.getPrice() * item.getNum());
    }

    /**
     * 促销商品价格处理
     *
     * @param item
     */
    @Override
    public void visitPromotionItem(PromotionalItem item) {
        refreshPrice(item);
        item.setAmount(item.getPrice() * item.getNum() * item.getDiscount());
    }

    private void refreshPrice(AbstractItem item) {
        item.setPrice(priceService.queryPriceByItemId(item.getId()));
    }

    public double getCartAmount() {
        return amount;
    }
}
