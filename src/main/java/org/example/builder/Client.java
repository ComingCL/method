package org.example.builder;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        TeSilaBuilder teSilaBuilder = new TeSilaBuilder();
        WuLingBuilder wuLingBuilder = new WuLingBuilder();
        ArrayList<String> order = new ArrayList<>();
        order.add("start");
        order.add("alarm");
        order.add("stop");
        teSilaBuilder.setOrder(order);
        TeSila car = teSilaBuilder.getCar();
        car.run();

        wuLingBuilder.setOrder(order);
        WuLing car2 = wuLingBuilder.getCar();
        car2.run();
    }
}
