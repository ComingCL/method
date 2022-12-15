package org.example;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ComingLiu
 * @Date: 2022/11/3 23:53
 */
public class myTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for(int i=1;i<=10;i++) list.add(i);
        System.out.println(list.size());
        System.out.println(list.get(12));
    }
}
