package com.walking.intensive.chapter3.task11;

public class Task11 {
    public static void main(String[] args) {

    }

    static int getOddSubArraysElementsSum(int[] array) {

        for (int value : array) {
            if (value < 0) {
                return -1;
            }
        }

        int subArrayLength = array.length - (array.length + 1) % 2;
        int sum = 0;

        do {
            for (int j = 0; j <= array.length - subArrayLength; j++) {

                for (int k = 0; k < subArrayLength; k++) {
                    sum += array[j + k];
                }
            }

            subArrayLength -= 2;

        } while (subArrayLength > 0);

        return sum;
    }
}
