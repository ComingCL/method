package org.example.bridge;

public class Circle extends Shape{
    private final int x, y, r;
    protected Circle(int x, int y, int r, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(x, y, r);
    }
}
