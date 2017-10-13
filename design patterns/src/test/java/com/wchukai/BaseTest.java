package com.wchukai;

/**
 * Created by chulung on 2017/9/22.
 */
public class BaseTest {

    public void println(Object... infos) {
        for (Object info : infos) {
            System.out.print(info + " ");
        }
        System.out.println("");
    }
}
