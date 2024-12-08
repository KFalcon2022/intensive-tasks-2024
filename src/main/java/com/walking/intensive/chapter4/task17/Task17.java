package com.walking.intensive.chapter4.task17;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task17 {
    public static void main(String[] args) {

        int[] array = {65, 66, 121, 4, 24, 7, 3, 12, 84, 56, 0, 1, -2};

//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(sortByQuicksort(array)));
        System.out.println(getBenchmarkOn1000());
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

    /**
     * Создайте массив случайных целых чисел из 1 000 элементов и сравните время,
     * которое потребуются для каждой из сортировок.
     * Ожидаемое возвращаемое значение - разница в выполнении сортировки в миллисекундах.
     *
     * <p>Для получения текущего UNIX-времени (в миллисекундах) можно использовать `System.currentTimeMillis()`.
     * Время выполнения - разность времени после работы алгоритма и времени до работы алгоритма
     */
    static long getBenchmarkOn1000() {

        int[] array = new int[1000];

        for (int i = 0; i < 1000; i++) {
            array[i] = ThreadLocalRandom.current().nextInt();
        }

        long startTime = System.currentTimeMillis();
        sortByBubble(array);
        long stopTime = System.currentTimeMillis();
        long elapsedTimeByBubble = stopTime - startTime;
        System.out.println(elapsedTimeByBubble);

        startTime = System.currentTimeMillis();
        sortByQuicksort(array);
        stopTime = System.currentTimeMillis();
        long elapsedTimeByQuick = stopTime - startTime;


        return elapsedTimeByBubble - elapsedTimeByQuick;
    }

    /**
     * Повторите предыдущие вычисления из метода getBenchmarkOn1000() для массива в 10 000 элементов.
     */
    static long getBenchmarkOn10000() {
        // Ваш код
        return 0;
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

        if (array.length == 0 || left > right) {
            return;
        }

        int i = left;
        int j = right;
        int separator = getAverage(array, i, j);

        while (i < j) {

            while (array[i] < separator) {
                i++;
            }

            while (array[j] > separator) {
                j--;
            }

            if (i < j) {
                elementsSwap(array, i, j);

//                System.out.println("Меняем "+ array[j] + " - " + array[i]);
//                System.out.println(Arrays.toString(array));
                i++;
                j--;
            }

            if (i == j) {
                i++;
                j--;
            }

            if (left < j) {
                arraySorting(array, left, j);
            }

            if (right > i) {
                arraySorting(array, i, right);
            }
        }
    }
}
