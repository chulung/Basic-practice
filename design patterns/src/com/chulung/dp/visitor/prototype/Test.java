package com.chulung.dp.visitor.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chulung on 2017/8/28.
 */
public class Test {
    List<Element> list;
    public static final void main(String[] args) {
        List<Element> list = new ArrayList() {
            {
                add(new ElementA());
                add(new ElementB());
            }
        };
        AbstractVisitor visitor1 = new Visitor1();
        list.forEach(element -> {
            element.accept(visitor1);
        });
        AbstractVisitor visitor2 = new Visitor2();
        list.forEach(element -> {
            element.accept(visitor2);
        });
    }
}
