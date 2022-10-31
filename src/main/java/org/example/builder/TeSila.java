package org.example.builder;

public class TeSila extends Car{
    @Override
    protected void start() {
        System.out.println("TeSila started.");
    }

    @Override
    protected void stop() {
        System.out.println("TeSila stopped.");
    }

    @Override
    protected void alarm() {
        System.out.println("TeSila alarmed.");
    }
}
