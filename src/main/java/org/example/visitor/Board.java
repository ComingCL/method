package org.example.visitor;

public class Board extends ComputerPart{
    @Override
    void accepted(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 800;
    }
}
