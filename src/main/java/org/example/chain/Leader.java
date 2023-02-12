package org.example.chain;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/12/15:04
 * @Description:
 */
public class Leader extends Handler{

    @Override
    public void process(Integer days) {
        if(days <= 1) {
            System.out.println("Leader处理");
        }
        else {
            nextHandler.process(days);
        }
    }
}
