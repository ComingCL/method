package org.example.single;

public enum enumSingleton {
    INSTANCE;
    private enumSingleton() {
    }
    public static enumSingleton getInstance() {
        return INSTANCE;
    }
}
