package com.walking.intensive.chapter5.task19;

public class Parallelepiped {
    private Point first;
    private Point second;

    public Parallelepiped(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getNearestPointTo(Point point) {
        int maxX = Math.max(this.first.getX(), this.second.getX());
        int minX = Math.min(this.first.getX(), this.second.getX());
        int maxY = Math.max(this.first.getY(), this.second.getY());
        int minY = Math.min(this.first.getY(), this.second.getY());
        int maxZ = Math.max(this.first.getZ(), this.second.getZ());
        int minZ = Math.min(this.first.getZ(), this.second.getZ());

        int x = Math.min(maxX, Math.max(point.getX(), minX));
        int y = Math.min(maxY, Math.max(point.getY(), minY));
        int z = Math.min(maxZ, Math.max(point.getZ(), minZ));

        return new Point(x, y, z);
    }
}
