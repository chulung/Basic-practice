package com.chulung.dp.visitor.cart.Visitor;

import com.chulung.dp.visitor.cart.domain.AbstractItem;
import com.chulung.dp.visitor.cart.domain.Cart;
import com.chulung.dp.visitor.cart.domain.GeneralItem;
import com.chulung.dp.visitor.cart.domain.PromotionalItem;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chulung on 2017/8/28.
 */
public abstract class AbstractCartVisitor implements CartVisitor {

    private static final ThreadPoolExecutor threadPoolExecutor;

    static {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, 20, 10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            private AtomicInteger index = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                //增加线程名
                Thread t = new Thread(r);
                t.setName("cartVisitor-thread-" + index.incrementAndGet());
                return t;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                r.run();
            }
        });
    }

    @Override
    public void visit(Cart cart) {
        for (AbstractItem item : cart.getItems()) {
            item.accept(this);
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

    @Override
    public void visitPromotionItem(PromotionalItem item) {
        visitDefault(item);
    }
}
