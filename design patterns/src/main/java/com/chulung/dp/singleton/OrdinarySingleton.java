package com.chulung.dp.singleton;

/**
 * Created by chulung on 2017/9/26.
 */
public class OrdinarySingleton {
    private static final OrdinarySingleton INSTANCE = new OrdinarySingleton();

    public OrdinarySingleton getInstance() {
        return INSTANCE;
    }
}
