package org.example.single;

public class staticSingleton {
    private staticSingleton(){
    }
    private static class InstanceHolder{
        private final static staticSingleton instance = new staticSingleton();
    }
    public static staticSingleton getInstance(){
        return InstanceHolder.instance;
    }
}
