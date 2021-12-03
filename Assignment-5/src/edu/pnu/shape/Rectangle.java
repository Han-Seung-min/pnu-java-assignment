package edu.pnu.shape;

public class Rectangle extends Shape{
    private int width, height;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
    }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("[Rectangle %d %d %.2f]", width, height, getArea());
    }
}
