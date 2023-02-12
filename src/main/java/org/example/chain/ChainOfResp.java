package org.example.chain;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/12/14:59
 * @Description:
 */
public class ChainOfResp {
    public static void main(String[] args) {
        Handler handler1 = new Leader();
        Handler handler2 = new Boss();
        handler1.setNextHandler(handler2);
        handler1.process(1);
        handler1.process(2);
    }
}
