package org.example.flyweight;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/11/10:49
 * @Description:
 */
public class MoBike extends Bike{
    private final String id;
    public MoBike(String id){
        this.id = id;
    }
    @Override
    void ride(String username) {
        state = 1;
        System.out.println(username + "骑" + id + "出行");
    }

    @Override
    void back() {
        state = 0;
    }
}
