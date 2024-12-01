package com.walking.intensive.chapter3.task13;

public class Task13 {
    public static void main(String[] args) {

        var plants = new int[]{7, 1, 0, 5, 3};
        var wateringCanVolume = 8;

        System.out.println(getStepsCount(plants, wateringCanVolume));
    }

    static int getStepsCount(int[] plants, int wateringCanVolume) {

        for (int plant : plants) {

            if (plant < 0 || wateringCanVolume < 0 || plant > wateringCanVolume) {
                return -1;
            }
        }

        int currentPosition = -1;
        int currentWater = wateringCanVolume;
        int totalSteps = 0;
        boolean isWatered = false;
        int notWateredPlants;

        while (!isWatered) {

            notWateredPlants = 0;

            for (int i = 0; i < plants.length; i++) {

                if (plants[i] == 0) {
                    continue;
                }

                if (plants[i] > currentWater) {
                    break;
                }

                totalSteps += i - currentPosition;
                currentPosition = i;
                currentWater -= plants[i];
                plants[i] = 0;
            }

            for (int plant : plants) {
                notWateredPlants += plant;
            }

            if (notWateredPlants > 0) {
                totalSteps += currentPosition + 1;
                currentPosition = -1;
                currentWater = wateringCanVolume;
            } else {
                isWatered = true;
            }


        }
        return totalSteps;
    }
}
