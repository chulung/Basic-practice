package com.chulung.dp.visitor.cart.Visitor;

import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.GeneralItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by chulung on 2017/8/28.
 */
public abstract class AbstractCartVisitor implements CartVisitor {

    private static final ThreadPoolExecutor threadPoolExecutor;

    static {
        //实际的线程池大小应该根据现有机器配置来处理，这里暂时设为4，便于测试对比
//        int availableProcessors = Runtime.getRuntime().availableProcessors();
        threadPoolExecutor = new ThreadPoolExecutor(4, 4,
                10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public void visit(Cart cart) {
        if (cart.getItems().size() <= 2) {
            for (AbstractItem item : cart.getItems()) {
                item.accept(this);
            }
        } else {
            CountDownLatch countDownLatch = new CountDownLatch(cart.getItems().size());
            final List<Future<?>> list = new ArrayList<>();
            cart.getItems().forEach(item -> {
                list.add(threadPoolExecutor.submit(new SubVisitor(item, countDownLatch)));
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void visitDefault(AbstractItem item) {
        //do nothing
    }

    @Override
    public void visitGeneralItem(GeneralItem generalItem) {
        visitDefault(generalItem);
    }


    private class SubVisitor implements Runnable {
        CountDownLatch countDownLatch;
        AbstractItem abstractItem;

        public SubVisitor(AbstractItem abstractItem, CountDownLatch countDownLatch) {
            this.abstractItem = abstractItem;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            abstractItem.accept(AbstractCartVisitor.this);
            countDownLatch.countDown();
        }
    }
}
