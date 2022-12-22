package org.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TargetInvoker implements InvocationHandler {

    private final Object target;

    public TargetInvoker(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before jdk handles");
        Object result = method.invoke(target, args);
        System.out.println("after jdk handles");
        return result;
    }
}
