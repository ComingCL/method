package org.example.proxy;

public class IntermediaryProxy{
    private RentHouse rentHouse = null;
    public IntermediaryProxy(RentHouse iRentHouse){
        this.rentHouse = iRentHouse;
    }
    public void rentHouse() {
        rentHouse.rentHouse();
    }
}
