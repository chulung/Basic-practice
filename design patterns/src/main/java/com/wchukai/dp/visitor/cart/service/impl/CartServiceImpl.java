package com.wchukai.dp.visitor.cart.service.impl;

import com.wchukai.dp.visitor.cart.Visitor.PriceVisitor;
import com.wchukai.dp.visitor.cart.domain.Cart;
import com.wchukai.dp.visitor.cart.service.CartService;

/**
 * Created by chulung on 2017/9/2.
 */
public class CartServiceImpl implements CartService {

    @Override
    public Cart refreshCart(Cart cart) {

        PriceVisitor priceVisitor = new PriceVisitor();
        priceVisitor.visit(cart);
        cart.setAmount(priceVisitor.getCartAmount());
        return cart;
    }
}
