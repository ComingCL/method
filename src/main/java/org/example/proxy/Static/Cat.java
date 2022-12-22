package org.example.proxy.Static;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("The cat is eating");
    }
    public void play(){
        System.out.println("The cat is playing");
    }
}
