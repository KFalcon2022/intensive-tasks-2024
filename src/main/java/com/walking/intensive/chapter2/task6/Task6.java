package com.walking.intensive.chapter2.task6;

import java.lang.Math;
/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getLcm(17, 5));
//        System.out.println(getGcdByEuclideanAlgorithm(51,35));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        // Ваш код
        if (isDataInvalid(m, n)) {
            return -1;
        }

        int greater = Math.max(m,n);
        int lower = Math.min(m, n);

        for (int i = 1; i < m * n; i++) {
            if (greater * i % lower == 0) {
                return greater * i;
            }
        }

        return greater * lower;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        // Ваш код
        if (isDataInvalid(m, n)) {
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
        // Ваш код
        if (isDataInvalid(m, n)) {
            return -1;
        }

        int greater = Math.max(m, n);
        int lower = Math.min(m, n);

        if (greater % lower == 0) {
            return lower;
        }
        return getGcdByEuclideanAlgorithm(lower, greater % lower);
    }

    static boolean isDataInvalid(int m, int n) {
        return m < 1 || n < 1;
    }
}
