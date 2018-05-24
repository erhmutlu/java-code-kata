package org.erhmutlu.kata.accessPrivate.v1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PowerOfTwoChecker {

    public static boolean checkPowerOf2(int num) throws Exception {
        Class<Inner.Private> privateClz = Inner.Private.class;

        Constructor<Inner.Private> privateClzDeclaredConstructor = privateClz.getDeclaredConstructor(Inner.class);
        privateClzDeclaredConstructor.setAccessible(true);

        Object o = privateClzDeclaredConstructor.newInstance(new Inner());

        Method method = privateClz.getDeclaredMethod("isPowerOf2", int.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(o, num);
    }

    static class Inner {
        private class Private {
            private boolean isPowerOf2(int num) {
                return (num & num - 1) == 0;
            }
        }
    }
}
