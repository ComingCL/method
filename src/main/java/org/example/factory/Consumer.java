package org.example.factory;

public class Consumer {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("WuLing");
        if(car != null){
            car.name();
        }
        Car car1 = CarFactory.getCar("TeSila");
        if(car1 != null){
            car1.name();
        }
    }
}