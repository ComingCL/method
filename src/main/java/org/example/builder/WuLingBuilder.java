package org.example.builder;

import java.util.ArrayList;

public class WuLingBuilder extends CarBuilder{
    private final WuLing car = new WuLing();

    @Override
    public void setOrder(ArrayList<String> order) {
        car.setOrder(order);
    }

    @Override
    public WuLing getCar() {
        return car;
    }
}
