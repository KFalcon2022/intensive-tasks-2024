package com.walking.intensive.chapter5.task19;

public class Parallelepiped {
    private final Point first;
    private final Point second;

    public Parallelepiped(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public Point getNearestPointTo(Point point) {
        int maxX = Math.max(this.first.getX(), this.second.getX());
        int minX = Math.min(this.first.getX(), this.second.getX());
        int maxY = Math.max(this.first.getY(), this.second.getY());
        int minY = Math.min(this.first.getY(), this.second.getY());
        int maxZ = Math.max(this.first.getZ(), this.second.getZ());
        int minZ = Math.min(this.first.getZ(), this.second.getZ());

        int minDistanceToEdge = Integer.MAX_VALUE;
        int[] planes = new int[]{maxX, minX, maxY, minY, maxZ, minZ};
        int pointCoordinate;

        for (int i = 0; i < 6; i++) {
            pointCoordinate = switch (i) {
                case 0, 1 -> point.getX();
                case 2, 3 -> point.getY();
                case 4, 5 -> point.getZ();
                default -> throw new IllegalStateException("Unexpected value: " + i);
            };

            minDistanceToEdge = Math.min(minDistanceToEdge, Math.abs(planes[i] - pointCoordinate));
        }

        int x = Math.min(maxX, Math.max(point.getX(), minX));
        int y = Math.min(maxY, Math.max(point.getY(), minY));
        int z = Math.min(maxZ, Math.max(point.getZ(), minZ));

        if (minX < x && x < maxX && minDistanceToEdge == Math.abs(x - minX)) {
            x = minX;
            return new Point(x, y, z);
        }
        if (minX < x && x < maxX && minDistanceToEdge == Math.abs(x - maxX)) {
            x = maxX;
            return new Point(x, y, z);
        }
        if (minY < y && y < maxY && minDistanceToEdge == Math.abs(y - minY)) {
            y = minY;
            return new Point(x, y, z);
        }
        if (minY < y && y < maxY && minDistanceToEdge == Math.abs(y - maxY)) {
            y = maxY;
            return new Point(x, y, z);
        }
        if (minZ < z && z < maxZ && minDistanceToEdge == Math.abs(z - minZ)) {
            z = minZ;
            return new Point(x, y, z);
        }
        if (minZ < z && z < maxZ && minDistanceToEdge == Math.abs(z - maxZ)) {
            z = maxZ;
            return new Point(x, y, z);
        }

        return new Point(x, y, z);
    }

    public Point getFarthestPointTo(Point point) {
        int maxX = Math.max(this.first.getX(), this.second.getX());
        int minX = Math.min(this.first.getX(), this.second.getX());
        int maxY = Math.max(this.first.getY(), this.second.getY());
        int minY = Math.min(this.first.getY(), this.second.getY());
        int maxZ = Math.max(this.first.getZ(), this.second.getZ());
        int minZ = Math.min(this.first.getZ(), this.second.getZ());

        double maxDistance = -1;
        double currentDistance;
        Point farthestPoint = null;

        Point corner1 = new Point(maxX, maxY, maxZ);
        Point corner2 = new Point(maxX, maxY, minZ);
        Point corner3 = new Point(maxX, minY, maxZ);
        Point corner4 = new Point(maxX, minY, minZ);
        Point corner5 = new Point(minX, maxY, maxZ);
        Point corner6 = new Point(minX, maxY, minZ);
        Point corner7 = new Point(minX, minY, maxZ);
        Point corner8 = new Point(minX, minY, minZ);

        Point[] corners = new Point[]{corner1, corner2, corner3, corner4, corner5, corner6, corner7, corner8};
        
        for (Point corner: corners) {
            currentDistance = point.getDistanceTo(corner);
            
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                farthestPoint = corner;
            }
        }
        
        return farthestPoint;
    }
}
