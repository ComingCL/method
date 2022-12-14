package org.example.single;

/**
 * @Author: ComingLiu
 * @Date: 2022/11/4 0:21
 */
public class LazyMan {
    private LazyMan(){
    }

    private volatile static LazyMan lazyMan;// 防止指令重排

    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();// 不是原子操作
                    /**
                     * 1. 分配内存空间
                     * 2. 执行构造方法, 初始化对象
                     * 3. 把这个对象指向这个空间
                     * (可能指令重排, 导致没有完成构造方法)
                     */
                }
            }
        }
        return lazyMan;
    }
}
