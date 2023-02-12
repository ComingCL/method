package org.example.chain;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/12/15:04
 * @Description:
 */
public class Boss extends Handler{

    @Override
    public void process(Integer days) {
        System.out.println("Boss处理");
    }
}
