package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println(getLcm(15, 25));
        System.out.println(getGcd(12, 6));
        System.out.println(getGcdByEuclideanAlgorithm(2, 2));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        return (m * n) / getGcdByEuclideanAlgorithm(m, n);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        int gcd = 0;
        int max = Math.max(m, n);

        for (int i = 1; i <= max; i++) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        if (m == n) {
            return m;
        }

        while (m != n) {
            if (m > n) {
                m -= n;
            }
            if (m < n) {
                n -= m;
            }
        }

        return m;
    }
}
