package org.example.decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/08/18:20
 * @Description:
 */
public class RobotDecorator implements Robot{
    private final Robot robot;
    public RobotDecorator(Robot robot){
        this.robot = robot;
    }
    @Override
    public void doSomeThing() {
        robot.doSomeThing();
    }
    public void doMoreThing(){
        doSomeThing();
        System.out.println("走路");
    }
}
