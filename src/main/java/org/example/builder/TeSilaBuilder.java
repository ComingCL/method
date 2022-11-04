package org.example.builder;

import java.util.ArrayList;

public class TeSilaBuilder extends CarBuilder{

    private final TeSila car = new TeSila();

    @Override
    public void setOrder(ArrayList<String> order) {
        car.setOrder(order);
    }

    @Override
    public TeSila getCar() {
        return car;
    }
}

