package org.example.builder;

public class WuLing extends Car{
    @Override
    protected void start() {
        System.out.println("WuLing started.");
    }

    @Override
    protected void stop() {
        System.out.println("WuLing stopped.");
    }

    @Override
    protected void alarm() {
        System.out.println("WuLing alarmed.");
    }
}
