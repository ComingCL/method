package org.example.facade;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/10/0:32
 * @Description:
 */
public class Facade {
    System1 system1 = new System1();
    System2 system2 = new System2();
    System3 system3 = new System3();
    boolean prove(){
        return system1.module() && system2.module() && system3.module();
    }
}
