package org.example.proxy.jdk;

import org.example.proxy.Static.Animal;
import org.example.proxy.Static.Cat;

public class JDKDemo {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        Animal proxy = (Animal) DynamicProxyAnimal.getProxy(cat);
        proxy.eat();
    }
}
