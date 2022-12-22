package org.example.proxy;


public class proxyTest {
    public static void main(String[] args) {
        RentHouse rentHouse = new IRentHouse();
        rentHouse.getProxy().rentHouse();
    }
}
