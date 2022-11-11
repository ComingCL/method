package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IntermediaryProxy implements InvocationHandler {
    private final Object target;
    public IntermediaryProxy(Object iRentHouse){
        this.target = iRentHouse;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
