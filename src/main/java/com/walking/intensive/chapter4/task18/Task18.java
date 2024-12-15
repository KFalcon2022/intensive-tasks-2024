package com.walking.intensive.chapter4.task18;

public class Task18 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static int find(int[] girlAges, int targetAge) {
        int left = 0;
        int right = girlAges.length - 1;
        int separator = 0;
        while (left <= right) {
            separator = (left + right) / 2;

            if (girlAges[separator] == targetAge) {
                return girlAges[separator];
            }

            if (girlAges[separator] > targetAge) {
                right = separator - 1;
            } else {
                left = separator + 1;
            }
        }
         if (separator <= 0) {
             return -1;
         }

        return girlAges[separator - 1];
    }
}
