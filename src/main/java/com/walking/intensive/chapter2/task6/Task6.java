package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        System.out.println(getGcdByEuclideanAlgorithm(m, n));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static boolean getCorrectData(int m, int n) {
    return m < 1 || n < 1;
    }

    static int getLcm(int m, int n) {
        if (getCorrectData(m,n)) {
            return -1;
        }

        int lcm = 1;

        while (lcm % m != 0 || lcm % n != 0) {
            lcm++;
        }
        return lcm;
    }


    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (getCorrectData(m,n)) {
            return -1;
        }

        return m * n / getLcm(m, n);
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
        if (getCorrectData(m,n)) {
            return -1;
        }

        if (m%n == 0) {
            return n;
        }

        return getGcdByEuclideanAlgorithm(n, m%n);
    }
}
