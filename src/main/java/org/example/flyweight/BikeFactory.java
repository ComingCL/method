package org.example.flyweight;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/11/10:52
 * @Description:
 */
public class BikeFactory {
    private static final BikeFactory instance = new BikeFactory();
    private final Set<Bike> pool = new HashSet<>();

    public static BikeFactory getInstance() {
        return instance;
    }
    private BikeFactory(){// 饿汉式创建单例
        for(int i=0;i<2;i++){
            pool.add(new MoBike(i + "号"));
        }
    }
    public Bike getBike(){
        for(Bike bike : pool){
            if(bike.getState() == 0){
                return bike;
            }
        }
        return null;
    }
}
