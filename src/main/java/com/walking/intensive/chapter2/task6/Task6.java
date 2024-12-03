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

    static int getLcm(int m, int n) {
        if (!isValid(m, n)) {
            return -1;
        }

        int Lcm = m;
        while (Lcm % n != 0) {
            Lcm += m;
        }

        return Lcm;
    }

    static int getGcd(int m, int n) {
        if (!isValid(m, n)) {
            return -1;
        }

        return (m > n ? getGcdSet(m, n) : getGcdSet(n, m));
    }

    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (!isValid(m, n)) {
            return -1;
        }

        int x = m % n;
        if (x == 0) {
            return n;
        }

        return getGcdByEuclideanAlgorithm(n, x);
    }

    static boolean isValid(int n, int m) {
        return m > 0 && n > 0;
    }

    static int getGcdSet(int m, int n) {
        int x = n;

        while (m % x != 0) {
            x = m % x;
        }

        while (n % x != 0) {
            x = n % x;
        }

        return x;
    }
}
