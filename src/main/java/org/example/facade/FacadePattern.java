package org.example.facade;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Clarence
 * @Date: 2023/02/10/0:29
 * @Description:
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        if(facade.prove()){
            System.out.println("子模块正常");
        }else{
            System.out.println("子模块异常");
        }
    }
}
