package com.chulung.dp.visitor.prototype;

/**
 * Created by chulung on 2017/8/28.
 */
public class Visitor1 extends AbstractVisitor {

    @Override
    public void visitElementA(ElementA elementA) {
        System.out.println("visitor1 " + elementA.getClass().getSimpleName());
    }

    @Override
    public void visitElementB(ElementB elementB) {
        System.out.println("visitor1 " + elementB.getClass().getSimpleName());
    }
}
