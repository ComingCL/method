package org.example.proxy.CGLib;

import org.example.proxy.Static.Animal;
import org.example.proxy.Static.Cat;

public class CGLibDemo {
    public static void main(String[] args) {
        Cat cat = (Cat) CGLibProxy.getProxy(Cat.class);
        cat.play();
    }
}
