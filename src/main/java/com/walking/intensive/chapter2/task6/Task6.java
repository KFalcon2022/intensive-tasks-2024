package com.walking.intensive.chapter2.task6;

public class Task6 {
    public static void main(String[] args) {
        int n = 5;
        int m = 7;

        System.out.println(getLcm(m, n));
        System.out.println(getGcd(m, n));
        System.out.println("Euc: " + getGcdByEuclideanAlgorithm(m, n));
    }

    static boolean isValidate(int m, int n) {
        return (m > 0 && n > 0);
    }

    static int getLcm(int m, int n) {

        if (!isValidate(m, n)) {
            return -1;
        }

        int a = Math.max(m, n);
        int b = Math.min(m, n);
        int i = a;

        while (a % b != 0) {
            a += i;
        }

        return a;
    }

    static int getGcd(int m, int n) {

        if (!isValidate(m, n)) {
            return -1;
        }

        int i = Math.min(m, n);

        while (i != 1) {
            if (m % i == 0 && n % i == 0) {
                break;
            }
            i -= 1;
        }
        return i;
    }

    static int getGcdByEuclideanAlgorithm(int m, int n) {

        if (!isValidate(m, n)) {
            return -1;
        }

        int a = Math.max(m, n);
        int b = Math.min(m, n);

        if (a % b == 0) {
            return b;
        }

        int i = a % b;

        while (i != 0) {
            a = b;
            b = i;
            i = a % b;
        }

        return b;
    }
}
