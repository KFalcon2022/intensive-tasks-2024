package com.walking.intensive.chapter5.task19;

public class Sphere {
    private final Point center;
    private final int radius;

    public Sphere(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }
}
