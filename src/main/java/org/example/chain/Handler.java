package org.example.chain;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/12/14:59
 * @Description: 参与者类
 */
abstract class Handler {
    protected Handler nextHandler;
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void process(Integer days);
}
