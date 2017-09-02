package com.chulung.dp.visitor.cart.service.impl;

import com.chulung.dp.visitor.cart.service.PromotionService;

import java.util.Random;

/**
 * Created by chulung on 2017/9/2.
 */
public class PromotionServiceImpl implements PromotionService {
    @Override
    public double queryDiscountByItemId(int id) {
        //模拟调用时间10毫秒
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextDouble();
    }
}
