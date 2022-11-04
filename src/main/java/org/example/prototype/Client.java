package org.example.prototype;

import java.util.Date;

/**
 * @Author: ComingLiu
 * @Date: 2022/11/4 0:47
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video v1 = new Video("hello", date);
        Video v2 = (Video) v1.clone();// 浅克隆, 基本类型拷贝, 引用类型指向同一地址
        System.out.println(v1);
        System.out.println(v2);
        date.setTime(123);
        System.out.println(v1);
        System.out.println(v2);
    }
}
