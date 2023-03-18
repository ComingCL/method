package org.example.mediator;

public class Colleague2 extends Colleague{
    @Override
    public void receive() {
        System.out.println("Colleague2 receives a message.");
    }

    @Override
    public void send() {
        System.out.println("Colleague2 sends a message.");
        this.mediator.communication(this);
    }
}
