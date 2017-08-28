package com.chulung.dp.visitor.prototype;

/**
 * Created by chulung on 2017/8/28.
 */
public abstract class AbstractVisitor {
    public void visitDefault(Element element) {
        System.out.println("默认处理" + element.getClass().getSimpleName());
    }

    public void visitElementA(ElementA elementA) {
        visitDefault(elementA);
    }

    public void visitElementB(ElementB elementB) {
        visitDefault(elementB);
    }
}
