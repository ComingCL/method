package org.example.locks;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class locksTest{
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        locksTest test = new locksTest();
        Thread thread = new Thread((Runnable) test);
        thread.start();
        try{
            System.out.println("hello world");
        }finally {
            lock.unlock();
        }
    }
}
