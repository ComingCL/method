package org.example.mediator;

import java.util.ArrayList;

public class ConcreteMediator extends Mediator{
    private ArrayList<Colleague> colleagues;
    ConcreteMediator() {
        colleagues = new ArrayList<>();
    }
    @Override
    void communication(Colleague colleague) {
        colleagues.forEach(coll -> {
            if(!coll.equals(colleague)) {
                coll.receive();
            }
        });
    }

    @Override
    void register(Colleague colleague) {
        colleagues.add(colleague);
        colleague.mediator = this;
    }
}
