package org.example.decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/08/21:37
 * @Description:
 */
public class Decorator {
    public static void main(String[] args) {
        RobotDecorator decorator = new RobotDecorator(new FirstRobot());
        decorator.doMoreThing();
    }
}
