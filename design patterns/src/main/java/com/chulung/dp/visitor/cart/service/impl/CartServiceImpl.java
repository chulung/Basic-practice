package com.chulung.dp.visitor.cart.service.impl;

import com.chulung.dp.visitor.cart.Visitor.PriceVisitor;
import com.chulung.dp.visitor.cart.Visitor.PromotionVisitor;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.service.CartService;

/**
 * Created by chulung on 2017/9/2.
 */
public class CartServiceImpl implements CartService {

    @Override
    public Cart refreshCart(Cart cart) {

        PromotionVisitor promotionVisitor = new PromotionVisitor();
        promotionVisitor.visit(cart);
        PriceVisitor priceVisitor = new PriceVisitor();
        priceVisitor.visit(cart);
        cart.setAmount(priceVisitor.getCartAmount());
        return cart;
    }
}
