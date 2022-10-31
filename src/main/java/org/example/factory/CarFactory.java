package org.example.factory;

public class CarFactory {
    public static Car getCar(String car){
        switch (car){
            case "WuLing":{
                return new WuLing();
            }
            case "TeSila":{
                return new TeSila();
            }
            default:{
                return null;
            }
        }
    }
}
