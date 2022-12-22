package org.example.proxy.Static;

public class StaticProxyAnimal implements Animal{

    private final Animal animal;
    public StaticProxyAnimal(Animal animal){
        this.animal = animal;
    }
    @Override
    public void eat() {
        System.out.println("The cat is hungry");
        animal.eat();
    }
}
