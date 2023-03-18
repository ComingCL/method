package org.example.mediator;

public class Colleague1 extends Colleague{
    @Override
    public void receive() {
        System.out.println("Colleague1 receives a message.");
    }

    @Override
    public void send() {
        System.out.println("Colleague1 sends a message.");
        mediator.communication(this);
    }
}
