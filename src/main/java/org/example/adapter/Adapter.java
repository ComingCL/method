package org.example.adapter;

public class Adapter {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.charge();
        ThreeHole threeHole = new ThreeHoleImpl();
        TwoHoleAdapter twoHoleAdapter = new TwoHoleAdapter(threeHole);
        hotel.setThreeHole(twoHoleAdapter);
        hotel.charge();
    }
}
