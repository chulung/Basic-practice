package com.wchukai.dp.visitor.cart.service;

import com.wchukai.dp.visitor.cart.domain.Cart;

/**
 * Created by chulung on 2017/9/2.
 */
public interface CartService {
    /**
     * 刷新购物车商品价格
     *
     * @param cart
     * @return
     */
    Cart refreshCart(Cart cart);
}
