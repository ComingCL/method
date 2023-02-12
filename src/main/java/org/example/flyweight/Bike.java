package org.example.flyweight;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/11/10:48
 * @Description:
 */
abstract public class Bike {
    protected Integer state = 0;

    /**
     * 使用
     */
    abstract void ride(String username);

    /**
     * 归还
     */
    abstract void back();

    public Integer getState() {
        return state;
    }
}
