package org.example.visitor;

public abstract class ComputerPart {
    abstract void accepted(Visitor v);
    abstract double getPrice();
}
