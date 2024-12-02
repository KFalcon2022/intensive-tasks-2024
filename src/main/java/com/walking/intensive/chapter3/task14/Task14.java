package com.walking.intensive.chapter3.task14;

import java.util.Arrays;

public class Task14 {

    public static void main(String[] args) {

        int[][] objectLocations = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] radars = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};

        System.out.println(Arrays.toString(getObjectCounts(objectLocations, radars)));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {

        for (int[] object : objectLocations) {

            if (object.length != 2) {
                return new int[0];
            }

            for (int coords : object) {

                if (coords < 0) {
                    return new int[0];
                }
            }
        }

        for (int[] radar : radars) {

            if (radar.length != 3) {
                return new int[0];
            }

            for (int coords : radar) {

                if (coords < 0) {
                    return new int[0];
                }
            }
        }

        double distance;
        double coverage;
        int[] objectCounts = new int[radars.length];

        for (int i = 0; i < radars.length; i++) {

            coverage = radars[i][2];

            for (int[] object : objectLocations) {

                distance = Math.hypot(radars[i][0] - object[0], radars[i][1] - object[1]);

                if (coverage >= distance) {
                    objectCounts[i] += 1;
                }
            }
        }

        return objectCounts;
    }
}
