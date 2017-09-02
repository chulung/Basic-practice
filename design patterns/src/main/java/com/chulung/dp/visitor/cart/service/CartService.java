package com.chulung.dp.visitor.cart.service;

import com.chulung.dp.visitor.cart.domain.Cart;

/**
 * Created by chulung on 2017/9/2.
 */
public interface CartService {
    Cart refreshCart(Cart cart);
}
