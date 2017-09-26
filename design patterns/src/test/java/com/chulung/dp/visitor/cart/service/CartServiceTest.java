package com.chulung.dp.visitor.cart.service;


import com.chulung.BaseTest;
import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.GeneralItem;
import com.chulung.dp.visitor.cart.service.impl.CartServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chulung on 2017/9/2.
 */
public class CartServiceTest extends BaseTest {

    @Test
    public void refreshCart() throws Exception {
        List<AbstractItem> list = new ArrayList();
        list.add(new GeneralItem(1, 1));
        Cart cart = new Cart();
        cart.setItems(list);
        CartService cartService = new CartServiceImpl();

        refresh(list, cart, cartService);

        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);

        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);
        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);
        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);
        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);
        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);
        cart.getItems().add(new GeneralItem(1, 1));
        refresh(list, cart, cartService);

    }

    private void refresh(List<AbstractItem> list, Cart cart, CartService cartService) {
        long st = System.currentTimeMillis();
        int count = 100;
        for (int i = 0; i <= count; i++) {
            cartService.refreshCart(cart);
        }
        println("数量", list.size(), "金额", cart.getAmount(), "耗时 ", (System.currentTimeMillis() - st) / count);
    }

}