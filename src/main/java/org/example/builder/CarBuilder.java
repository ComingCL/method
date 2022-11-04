package org.example.builder;

import java.util.ArrayList;

public abstract class CarBuilder {
    public abstract void setOrder(ArrayList<String> sequence);
    public abstract Car getCar();
}
