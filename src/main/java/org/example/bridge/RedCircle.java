package org.example.bridge;

public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int x, int y, int r) {
        System.out.printf("Red x=%d, y=%d, r=%d\n", x, y, r);
    }
}
