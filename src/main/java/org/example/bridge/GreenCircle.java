package org.example.bridge;

public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int x, int y, int r) {
        System.out.printf("Green x=%d, y=%d, r=%d\n", x, y, r);
    }
}
