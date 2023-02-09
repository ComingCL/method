package org.example.decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/08/18:19
 * @Description:
 */
public class FirstRobot implements Robot{
    @Override
    public void doSomeThing() {
        System.out.println("唱歌");
    }
}
