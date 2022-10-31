package org.example.builder;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        TeSila car = new TeSila();
        ArrayList<String> order = new ArrayList<>();
        order.add("start");
        order.add("alarm");
        order.add("stop");
        car.setOrder(order);
        car.run();

    }
}
