package com.walking.intensive.chapter5.task19;

public class Parallelepiped {

    private final int x1, y1, z1, x2, y2, z2;

    public Parallelepiped (int x1, int y1, int z1, int x2, int y2, int z2) {
        this.x1 = Math.min(x1,x2);
        this.x2 = Math.max(x1,x2);
        this.y1 = Math.min(y1,y2);
        this.y2 = Math.max(y1,y2);
        this.z1 = Math.min(z1,z2);
        this.z2 = Math.max(z1,z2);
    }

    public int[][] getCornersCoordinates () {

        int[][] coordinates = new int[8][3];

        coordinates [0] = new int[] {x1,y1,z1};
        coordinates [1] = new int[] {x1+x2,y1,z1};
        coordinates [2] = new int[] {x1,y1+y2,z1};
        coordinates [3] = new int[] {x1+x2,y1+y2,z1};
        coordinates [4] = new int[] {x2-x1,y2,z2};
        coordinates [5] = new int[] {x2,y2-y1,z2};
        coordinates [6] = new int[] {x2-x1,y2-y1,z2};
        coordinates [7] = new int[] {x2,y2,z2};

        return coordinates;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getZ1() {
        return z1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getZ2() {
        return z2;
    }
}
