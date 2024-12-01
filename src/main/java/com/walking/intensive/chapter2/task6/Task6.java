package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {

    public static void main(String[] args) {

        System.out.println(getGcdByEuclideanAlgorithm(96, 140));
        System.out.println(getGcdByEuclideanAlgorithm(17, 31));
        System.out.println(getLcm(17, 31));
        System.out.println(getGcd(17, 31));

    }

    static boolean isValidInput(int m, int n) {
        return m > 0 && n > 0;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        if (!isValidInput(m, n)) {
            return -1;
        }

        return m * n / getGcd(m, n);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        if (!isValidInput(m, n)) {
            return -1;
        }

        while (m > 0 && n > 0) {
            if (m > n) {
                m -= n;
            } else {
                n -= m;
            }
        }

        return Math.max(m, n);
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

        if (!isValidInput(m, n)) {
            return -1;
        }

        if (Math.max(m, n) % Math.min(m, n) == 0) {
            return Math.min(m, n);
        }

        return getGcdByEuclideanAlgorithm(Math.max(m, n) % Math.min(m, n), Math.min(m, n));
    }
}
