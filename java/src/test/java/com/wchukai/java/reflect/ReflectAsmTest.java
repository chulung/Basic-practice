package com.wchukai.java.reflect;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wchukai on 2017/10/10.
 */
public class ReflectAsmTest {

    public String getString() {
        return "abc";
    }


    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testInvoker();
        testInvoker();
        testInvoker();
        testInvoker();

    }

    private void testInvoker() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ReflectAsmTest reflectAsmTest = new ReflectAsmTest();
        begin();
        for (long i = 0; i < 100000000L; i++) {
            reflectAsmTest.getString();
        }
        end();

        Method method = ReflectAsmTest.class.getMethod("getString");
        begin();
        for (long i = 0; i < 100000000L; i++) {
            String s = (String) method.invoke(reflectAsmTest);
        }
        end();

        MethodAccess access = MethodAccess.get(ReflectAsmTest.class);
        int addNameIndex = access.getIndex("getString");
        begin();
        for (long i = 0; i < 100000000L; i++) {
            String s = (String)access.invoke(reflectAsmTest, addNameIndex);
        }
        end();
        System.out.println();
    }

    private void end() {
        System.out.println(System.currentTimeMillis() - time);
    }

    long time;

    private void begin() {
        time = System.currentTimeMillis();
    }
}
