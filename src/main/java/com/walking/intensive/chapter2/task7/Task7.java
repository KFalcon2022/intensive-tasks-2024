package com.walking.intensive.chapter2.task7;

public class Task7 {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println(getFriendlyPair(n));
    }

    static int getFriendlyPair(int n) {
        int maxNumber = 0;

        if (n < 2 || n > 1000000) {
            return -1;
        }

        for (int i = 1; i < n; i++) {
            int firstSum = 0;
            int secondSum = 0;

            for (int j = 1; j < i; j++) {

                if (i % j == 0) {
                    firstSum += j;
                }
            }

            for (int k = 1; k < firstSum; k++) {

                if (firstSum % k == 0) {
                    secondSum += k;
                }
            }

            if (firstSum == secondSum) {
                continue;
            }

            if (secondSum == i) {
                maxNumber = Math.max(i, firstSum);
            }
        }
        return maxNumber;
    }
}
