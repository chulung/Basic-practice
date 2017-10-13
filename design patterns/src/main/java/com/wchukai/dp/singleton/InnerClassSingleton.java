package com.wchukai.dp.singleton;

/**
 * Created by chulung on 2017/9/26.
 */
public class InnerClassSingleton {

    public InnerClassSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
