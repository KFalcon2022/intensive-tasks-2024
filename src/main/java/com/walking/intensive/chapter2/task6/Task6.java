package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        System.out.println(getGcdByEuclideanAlgorithm(15, 25));
//        System.out.println(getGcd(5, 7));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (!validate(m, n)) {
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
        if (!validate(m, n)) {
            return -1;
        }

        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }

        return m;
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
        if (n == 0) {
            return m;
        }

        if (m < n) {
            m = n - m;
            n = n - m;
            m = m + n;
        }

        if (!validate(m, n)) {
            return -1;
        }

        return getGcdByEuclideanAlgorithm(n, m % n);
    }

    static boolean validate(int m, int n) {
        return m > 0 && n > 0;
    }
}
