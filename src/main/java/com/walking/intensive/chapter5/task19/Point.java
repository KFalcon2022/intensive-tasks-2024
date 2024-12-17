package com.walking.intensive.chapter5.task19;

import static java.lang.Math.*;

public class Point {
    private final int x;
    private final int y;
    private final int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public double getDistanceTo(Point other) {
        return sqrt(pow(other.getX() - x, 2) + pow(other.getY() - y, 2) + pow(other.getZ() - z, 2));
    }
}
