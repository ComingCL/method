package org.example.visitor;

public class Memory extends ComputerPart{
    @Override
    void accepted(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 400;
    }
}
