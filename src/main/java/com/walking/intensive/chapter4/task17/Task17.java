package com.walking.intensive.chapter4.task17;

import java.util.concurrent.ThreadLocalRandom;

public class Task17 {
    public static void main(String[] args) {
        System.out.println("Разница при 1000: " + getBenchmarkOn1000());
        System.out.println("Разница при 10000: " + getBenchmarkOn10000());
    }

    static int[] sortByBubble(int[] array) {
        if (!isValid(array)) {
            return new int[0];
        }

        int tempValue;
        int len = array.length - 1;
        for (int j = len; j >= 1; j--) {
            for (int i = 0; i < len; i++) {
                if (array[i] > array[i + 1]) {
                    tempValue = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tempValue;
                }
            }
        }
        return array;
    }

    static int[] sortByQuicksort(int[] array) {
        if (!isValid(array)) {
            return new int[0];
        }

        arraySorting(array, 0, array.length - 1);
        return array;
    }

    static long getBenchmarkOn1000() {
        int[] originalArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            originalArray[i] = ThreadLocalRandom.current().nextInt(-500, 500);
        }
        int[] bubbleArray = originalArray.clone();
        long startTime = System.currentTimeMillis();
        sortByBubble(bubbleArray);
        long stopTime = System.currentTimeMillis();
        long elapsedTimeByBubble = stopTime - startTime;
        System.out.println("Сортировка пузырьком: " + elapsedTimeByBubble);
        int[] quickArray = originalArray.clone();
        startTime = System.currentTimeMillis();
        sortByQuicksort(quickArray);
        stopTime = System.currentTimeMillis();
        long elapsedTimeByQuick = stopTime - startTime;
        System.out.println("Быстрая сортировка: " + elapsedTimeByQuick);
        return elapsedTimeByBubble - elapsedTimeByQuick;
    }

    static long getBenchmarkOn10000() {
        int[] originalArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            originalArray[i] = ThreadLocalRandom.current().nextInt(-1000, 1000);
        }
        int[] bubbleArray = originalArray.clone();
        long startTime = System.currentTimeMillis();
        sortByBubble(bubbleArray);
        long stopTime = System.currentTimeMillis();
        long elapsedTimeByBubble = stopTime - startTime;
        System.out.println("Сортировка пузырьком: " + elapsedTimeByBubble);
        int[] quickArray = originalArray.clone();
        startTime = System.currentTimeMillis();
        sortByQuicksort(quickArray);
        stopTime = System.currentTimeMillis();
        long elapsedTimeByQuick = stopTime - startTime;
        System.out.println("Быстрая сортировка: " + elapsedTimeByQuick);
        return elapsedTimeByBubble - elapsedTimeByQuick;
    }

    static boolean isValid(int[] array) {
        return array != null && array.length >= 1;
    }

    static int getAverage(int[] array, int i, int j) {
        int min = array[i];
        int max = array[i];
        for (int k = i; k <= j; k++) {
            if (array[k] < min) {
                min = array[k];
            }

            if (array[k] > max) {
                max = array[k];
            }
        }
        return (min + max) / 2;
    }

    static void elementsSwap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static void arraySorting(int[] array, int left, int right) {
        if (array == null || array.length < 2 || left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int separator = getAverage(array, left, right);
        while (i <= j) {
            while (array[i] < separator) {
                i++;
            }
            while (array[j] > separator) {
                j--;
            }

            if (i <= j) {
                elementsSwap(array, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            arraySorting(array, left, j);
        }

        if (i < right) {
            arraySorting(array, i, right);
        }
    }
}
