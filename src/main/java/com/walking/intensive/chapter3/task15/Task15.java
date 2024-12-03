package com.walking.intensive.chapter3.task15;

public class Task15 {
    public static void main(String[] args) {

        int[][] city = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};

        System.out.println(getMaxFloors(city));
    }

    static int getMaxFloors(int[][] city) {

        if (city.length < 1) {
            return -1;
        }

        for (int[] street : city) {

            if (street.length != city.length) {
                return -1;
            }

            for (int i = 0; i < city.length; i++) {

                if (street[i] < 0) {
                    return -1;
                }
            }
        }

        int[] horizontalProjection = new int[city.length];
        int[] verticalProjection = new int[city.length];

        for (int r = 0; r < city.length; r++) {

            for (int c = 0; c < city[r].length; c++) {

                if (city[r][c] > horizontalProjection[r]) {
                    horizontalProjection[r] = city[r][c];
                }

                if (city[r][c] > verticalProjection[c]) {
                    verticalProjection[c] = city[r][c];
                }
            }
        }

        int maxFloors = 0;

        for (int r = 0; r < city.length; r++) {

            for (int c = 0; c < city.length; c++) {

                if (city[r][c] <= verticalProjection[c]) {
                    if (city[r][c] < horizontalProjection[r]) {
                        city[r][c] = Math.max(horizontalProjection[r], verticalProjection[c]);
                        maxFloors += Math.abs(horizontalProjection[r] - verticalProjection[c]);
                    }
                }
            }
        }

        return maxFloors;
    }
}
