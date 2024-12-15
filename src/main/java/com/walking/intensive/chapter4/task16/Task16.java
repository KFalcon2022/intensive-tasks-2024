package com.walking.intensive.chapter4.task16;

import java.util.Arrays;

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
            result[i]++;
        }
        return result;
    }

    static int[] multiplyEach(int[] arr1, int[] arr2) {
        if (arr1.length == 0 && arr2.length == 0) {
            return new int[0];
        }

        int maxLength = Math.max(arr1.length, arr2.length);
        int[] result = new int[maxLength];
        int minLength = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < minLength; i++) {
            result[i] = arr1[i] * arr2[i];
        }
        return result;
    }

    static int[] subtractEach(int[] arr1, int[] arr2) {
        if (arr1.length == 0 && arr2.length == 0) {
            return new int[0];
        }

        int maxLength = Math.max(arr1.length, arr2.length);
        int[] result = new int[maxLength];
        int minLength = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < minLength; i++) {
            result[i] = arr1[i] - arr2[i];
        }

        if (arr1.length > arr2.length) {
            System.arraycopy(arr1, minLength, result, minLength, maxLength - minLength);
        } else {
            for (int i = minLength; i < maxLength; i++) {
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
        int maxLength = Math.max(arr.length, index);
        System.arraycopy(arr, index, result, index + 1, maxLength - index);
        result[index] = newValue;
        System.arraycopy(arr, 0, result, 0, index);
        return result;
    }

    static boolean isContains(int[] arr, int value) {
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
            int[] arr1 = new int[arr.length];
            System.arraycopy(arr, 0, arr1, 0, arr.length);
            return arr1;
        }

        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);

        if (arr.length - 1 - index >= 0) {
            System.arraycopy(arr, index + 1, result, index, arr.length - 1 - index);
        }
        return result;
    }

    static int[] removeAll(int[] arr, int... removingValues) {
        boolean[] markedIndex = new boolean[arr.length];
        int lengthLessening = 0;
        for (int removingValue : removingValues) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == removingValue) {
                    markedIndex[i] = true;
                    lengthLessening++;
                }
            }
        }
        int index = 0;
        int[] result = new int[arr.length - lengthLessening];
        for (int i = 0; i < arr.length; i++) {
            if (!markedIndex[i]) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    static boolean isSimilar(int[] arr1, int[] arr2) {
        int firstCounter = 0;
        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) {
                    firstCounter++;
                }
            }
            if (firstCounter == 0) {
                return false;
            }
        }
        int secondCounter = 0;
        for (int i : arr2) {
            for (int j : arr1) {
                if (i == j) {
                    secondCounter++;
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
        result[0] = arr[arr.length - 1];
        System.arraycopy(arr, 0, result, 1, arr.length - 1);
        return result;
    }
}
