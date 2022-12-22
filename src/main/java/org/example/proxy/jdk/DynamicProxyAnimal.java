package org.example.proxy.jdk;

import java.lang.reflect.Proxy;

public class DynamicProxyAnimal {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetInvoker(target)
        );
    }
}
