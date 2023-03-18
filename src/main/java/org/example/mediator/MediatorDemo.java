package org.example.mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        Colleague1 colleague1 = new Colleague1();
        Colleague2 colleague2 = new Colleague2();

        ConcreteMediator concreteMediator = new ConcreteMediator();
        concreteMediator.register(colleague1);
        concreteMediator.register(colleague2);

        colleague1.send();
        colleague2.send();
    }
}
