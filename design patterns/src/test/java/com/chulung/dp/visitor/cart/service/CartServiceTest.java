package com.chulung.dp.visitor.cart.service;


import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.GeneralItem;
import com.chulung.dp.visitor.cart.domain.PromotionalItem;
import com.chulung.dp.visitor.cart.service.impl.CartServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chulung on 2017/9/2.
 */
public class CartServiceTest {
    public void refreshCart() throws Exception {
        List<AbstractItem> list = new ArrayList() {
            {
                add(new GeneralItem(1));
                add(new GeneralItem(2));
                add(new PromotionalItem(3));
                add(new PromotionalItem(4));
            }
        };
        Cart cart =new Cart();
        cart.setItems(list);
        CartService cartService=new CartServiceImpl();
        cartService.refreshCart(cart);

    }

}