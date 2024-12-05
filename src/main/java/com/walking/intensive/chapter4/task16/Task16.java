package com.walking.intensive.chapter4.task16;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * После завершения интенсива вы достаточно быстро познакомитесь с Java Collection Framework.
 * Это знакомство позволит сильно упростить работу с массивами данных.
 *
 * <p>Но пока этого не произошло - даже типовые операции приходится производить вручную.
 * Эта задача - наглядная тому демонстрация.
 *
 * <p>Удачи!
 *
 * <p>P.S. Обратите внимание: если в методе требуется как-то изменять
 * содержимое массива - метод всегда должен возвращать новый массив.
 * Массивы, передаваемые в параметрах, изменяться не должны.
 * Это связано с тем, что в реальных условиях такой входящий массив может далее
 * использоваться в каких-либо иных расчетах и ожидается, что он будет находиться
 * в своем исходном состоянии.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task16 {
    public static void main(String[] args) {

        int[] arr1 = {10, 11, 14, 13};
        int[] arr2 = {10, 13, 12};
        System.out.println(isEqualSize(arr1, arr2));
        System.out.println(isEquals(arr1, arr2));
        System.out.println(Arrays.toString(multiplyEach(arr1, arr2)));
        System.out.println((Arrays.toString(subtractEach(arr1, arr2))));
        System.out.println(Arrays.toString(reverse(arr1)));
        System.out.println(Arrays.toString(add(arr1, 6, 555)));
    }

    static boolean isEqualSize(int[] arr1, int[] arr2) {
        return arr1.length != 0 && arr1.length == arr2.length;
    }

    static boolean isEquals(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    static int[] incrementEach(int[] arr) {

        if (arr.length == 0) {
            return new int[0];
        }

        int[] result = arr;

        for (int i = 0; i < arr.length; i++) {
            result[i] += 1;
        }

        return result;
    }

    static int[] multiplyEach(int[] arr1, int[] arr2) {

        if (arr1.length == 0 && arr2.length == 0) {
            return new int[0];
        }

        int[] result = new int[Math.max(arr1.length, arr2.length)];

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            result[i] = arr1[i] * arr2[i];
        }

        for (int i = Math.min(arr1.length, arr2.length); i < Math.max(arr1.length, arr2.length); i++) {
            result[i] = 0;
        }

        return result;
    }

    static int[] subtractEach(int[] arr1, int[] arr2) {

        if (arr1.length == 0 && arr2.length == 0) {
            return new int[0];
        }

        int[] result = new int[Math.max(arr1.length, arr2.length)];

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            result[i] = arr1[i] - arr2[i];
        }

        for (int i = Math.min(arr1.length, arr2.length); i < Math.max(arr1.length, arr2.length); i++) {

            if (arr1.length > arr2.length) {
                result[i] = arr1[i];
            } else {
                result[i] = -arr2[i];
            }
        }

        return result;
    }

    static int[] reverse(int[] arr) {

        if (arr.length == 0) {
            return new int[0];
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - i - 1];
        }

        return result;
    }

    static int[] add(int[] arr, int index, int newValue) {

        if (index < 0) {
            return new int[0];
        }

        if (index > arr.length + 1) {
            index = arr.length;
        }

        int[] result = new int[arr.length + 1];

        for (int i = Math.max(arr.length, index); i > index; i--) {
            result[i] = arr[i - 1];
        }

        result[index] = newValue;

        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    static boolean isContains(int[] arr, int value) {

        if (arr.length == 0) {
            return false;
        }

        for (int element : arr) {

            if (element == value) {
                return true;
            }
        }

        return false;
    }

    static int getFirstIndex(int[] arr, int value) {

        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    static int getLastIndex(int[] arr, int value) {

        if (arr.length == 0) {
            return -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    static int[] removeByIndex(int[] arr, int index) {

        if (arr.length == 0 || index < 0) {
            return new int[0];
        }

        if (index > arr.length) {
            return arr;
        }

        int[] result = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }

        for (int i = index; i < arr.length - 1; i++) {
            result[i] = arr[i + 1];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и
     * еще один массив целых чисел (в виде varargs).
     * И возвращает первый массив, удалив из него все числа, которые есть во втором.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60], [20,23,30]
     * <p>Возвращаемое значение: [10,40,50,60]
     */
    static int[] removeAll(int[] arr, int... removingValues) {

        int[] modifiedArr = arr;
        int index = arr.length;

        for (int i = 0; i < removingValues.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (removingValues[i] == arr[j]) {

                    for (int k = j; k < arr.length - 1; k++) {
                        modifiedArr[k] = arr[k + 1];
                    }
                    index -= 1;

                } else {
                    modifiedArr[j] = arr[j];
                }

            }
        }

        int[] result = new int[index];
        result = modifiedArr;

        return result;
    }

    static boolean isSimilar(int[] arr1, int[] arr2) {

        int firstCounter = 0;

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {
                    firstCounter += 1;
                }
            }
        }

        int secondCounter = 0;

        for (int i = 0; i < arr2.length; i++) {

            for (int j = 0; j < arr1.length; j++) {

                if (arr2[i] == arr1[j]) {
                    secondCounter += 1;
                }
            }
        }

        return firstCounter == arr1.length && secondCounter == arr2.length;
    }

    static int[] shiftIndex(int[] arr) {

        if (arr.length == 0) {
            return new int[0];
        }

        int[] result = new int[arr.length];
        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0 ; i--) {
            result[i] = arr[i - 1];
        }

        result[0] = lastElement;

        return result;
    }
}
