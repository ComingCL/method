package org.example.visitor;

public class CompanyVisitor implements Visitor {
    private double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.8;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.8;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.8;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}