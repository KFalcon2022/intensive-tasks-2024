package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        return m / getGcd(m, n) * n;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        if (m <= 0 || n <= 0) {
            return -1;
        }

        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int remainder = min;

        while (remainder != 0) {
            remainder = max % min;
            max = min;
            min = remainder;
        }

        return max;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {

        if (m <= 0 || n <= 0) {
            return -1;
        }

        if (m == n) {
            return m;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        if (m % 2 == 0 && n % 2 == 0) {
            return 2 * getGcd(m / 2, n / 2);
        }

        if (m % 2 == 0) {
            return getGcd(m / 2, n);
        }

        if (n % 2 == 0) {
            return getGcd(m, n / 2);
        }

        int max = Math.max(m, n);
        int min = Math.min(m, n);

        return getGcd((max - min) / 2, min);
    }
}
