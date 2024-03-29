package org.example.mediator;

public abstract class Colleague {
    protected Mediator mediator;
    public abstract void receive();
    public abstract void send();

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
