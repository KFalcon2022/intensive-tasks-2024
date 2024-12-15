package com.walking.intensive.chapter5.task19;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public double getDistanceTo(Point other) {
        return Math.sqrt(
                Math.pow(other.getX() - this.getX(), 2) +
                        Math.pow(other.getY() - this.getY(), 2) +
                        Math.pow(other.getZ() - this.getZ(), 2)
        );
    }
}
