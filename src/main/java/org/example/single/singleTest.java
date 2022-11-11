package org.example.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class singleTest {
    public static void main(String[] args) {
        enumSingleton singleton = enumSingleton.getInstance();
    }
}
