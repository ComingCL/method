package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class proxyTest {
    public static void main(String[] args) {
        RentHouse iRentHouse = new IRentHouse();
//        定义一个handler
        InvocationHandler handler = new IntermediaryProxy(iRentHouse);
//        获得类的class loader
        ClassLoader cl = iRentHouse.getClass().getClassLoader();
//        动态产生一个消费者
        RentHouse proxy = (RentHouse) Proxy.newProxyInstance(cl, new Class[]{RentHouse.class}, handler);
        proxy.getProxy().rentHouse();
    }
}
