package com.chulung.dp.singleton;

/**
 * Created by chulung on 2017/9/26.
 */
public class DoubleCheckSingleton {
    /**
     * volatile 禁止重排序，保证happen-before
     */
    private static volatile DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance() {
        // 临时变量减少一次对volatile变量的读取操作，可以提升性能，@"Effective Java, Second Edition", p. 283-284
        DoubleCheckSingleton result = instance;
        if (result == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    result = instance = new DoubleCheckSingleton();
                }
            }
        }
        return result;
    }

}
