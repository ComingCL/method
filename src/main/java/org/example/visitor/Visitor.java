package org.example.visitor;

public interface Visitor {
    double totalPrice = 0.0;
    void visitCpu(CPU cpu);
    void visitBoard(Board board);
    void visitMemory(Memory memory);
}
