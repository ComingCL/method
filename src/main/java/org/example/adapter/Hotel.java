package org.example.adapter;

public class Hotel {
    private TwoHole twoHole = new TwoHoleImpl();
    public void setThreeHole(TwoHole twoHole){
        this.twoHole = twoHole;
    }
    public void charge(){
        twoHole.charge();
    }
}
