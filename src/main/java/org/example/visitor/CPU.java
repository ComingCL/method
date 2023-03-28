package org.example.visitor;

public class CPU extends ComputerPart{

    @Override
    void accepted(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 1000;
    }
}
