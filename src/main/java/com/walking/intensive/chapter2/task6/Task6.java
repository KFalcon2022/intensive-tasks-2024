package com.walking.intensive.chapter2.task6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int m = in.nextInt();
        System.out.print("Введите второе число: ");
        int n = in.nextInt();

        System.out.println("НОК = " + getLcm(m, n));
        System.out.println("НОД = " + getGcd(m, n));
        System.out.println("НОД Евклид = " + getGcdByEuclideanAlgorithm(m, n));

    }

    static boolean isNumberNegative (int n, int m) {
        return m <= 0 || n <= 0;
    }

    static int getLcm(int m, int n) {
        if (isNumberNegative(m, n)) {
            return -1;
        }

        int x = m;
        while (m % n != 0) {
            m += x;
        }
        return m;
    }

    static int getGcd(int m, int n) {
        if (isNumberNegative(m, n)) {
            return -1;
        }

        if (m > n) {
            return getGcdIfFirstNumberIsBigger(m, n);
        }

        return getGcdIfFirstNumberIsBigger(n, m);
    }

    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (isNumberNegative(m, n)) {
            return -1;
        }
        int x = m % n;
        if (x == 0) {
            return n;
        }
        return getGcdByEuclideanAlgorithm(n, x);
    }

    static int getGcdIfFirstNumberIsBigger (int a, int b) {
        int x = b;
        while (a % x != 0) {
            x = a % x;
        }
        while (b % x != 0) {
            x = b % x;
        }
        return x;
    }
}
