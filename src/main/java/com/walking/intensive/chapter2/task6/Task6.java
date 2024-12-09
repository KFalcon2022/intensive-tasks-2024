package com.walking.intensive.chapter2.task6;

import java.util.Arrays;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
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

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
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

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
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

    static boolean isValidate(int m, int n) {
        return (m > 0 && n > 0);
    }
}
