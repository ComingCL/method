package org.example.builder;

import java.util.ArrayList;

public abstract class Car {
//    方法执行顺序
    private ArrayList<String> order = new ArrayList<>();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    final public void run(){
        for(String action : order){
            switch (action){
                case "start":{
                    this.start();
                    break;
                }
                case "stop":{
                    this.stop();
                    break;
                }
                case "alarm":{
                    this.alarm();
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }

    public Car setOrder(ArrayList<String> order) {
        this.order = order;
        return this;
    }
}
