package org.example.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Circle redCircle = new Circle(1, 2, 3, new RedCircle());
        Circle greenCircle = new Circle(1, 2, 3, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
