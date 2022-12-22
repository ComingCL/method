package org.example.proxy.Static;

public class StaticProxyAnimalDemo {
    public static void main(String[] args) {
        Animal cat = new StaticProxyAnimal(new Cat());
        cat.eat();
    }
}
