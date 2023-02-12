package org.example.flyweight;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/11/10:55
 * @Description:
 */
public class FlyWeight {
    public static void main(String[] args) {
        Bike bike = BikeFactory.getInstance().getBike();
        bike.ride("张三");

        Bike bike1 = BikeFactory.getInstance().getBike();
        bike1.ride("王五");
        bike1.back();

        Bike bike2 = BikeFactory.getInstance().getBike();
        bike2.ride("李四");
    }
}
