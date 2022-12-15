package org.example.adapter;

public class TwoHoleAdapter implements TwoHole{
    private ThreeHole threeHole = new ThreeHoleImpl();
    public TwoHoleAdapter(ThreeHole threeHole){
        this.threeHole = threeHole;
    }
    @Override
    public void charge() {
        threeHole.charge();
    }
}
