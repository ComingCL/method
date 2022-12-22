package org.example.proxy.CGLib;

import net.sf.cglib.proxy.Enhancer;

public class CGLibProxy {
    public static Object getProxy(Class<?> cls){
        Enhancer enhancer = new Enhancer();
//        设置类加载
        enhancer.setClassLoader(cls.getClassLoader());
//        设置被代理类
        enhancer.setSuperclass(cls);
//        设置方法拦截器
        enhancer.setCallback(new TargetInterceptor());
//        创建代理类
        return enhancer.create();
    }
}
