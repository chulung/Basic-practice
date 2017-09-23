package com.chulung.dp.visitor.cart.service.impl;

import com.chulung.dp.visitor.cart.service.PriceService;

/**
 * Created by chulung on 2017/9/2.
 */
public class PriceServiceImpl implements PriceService {
    @Override
    public double queryPriceByItemId(int id) {
        //模拟调用时间10毫秒
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
