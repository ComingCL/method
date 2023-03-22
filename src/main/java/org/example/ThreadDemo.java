package org.example;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("hello world");
        });
        thread.start();
        System.out.println(thread.getThreadGroup());
    }
}
