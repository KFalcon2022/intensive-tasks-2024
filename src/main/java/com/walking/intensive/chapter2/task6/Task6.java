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
        int m = 124;
        int n = 250;
//        System.out.println(getLcm(m, n));
//        System.out.println(getGcd(m, n));
        System.out.println(getGcdByEuclideanAlgorithm(m, n));
    }

    static boolean conditionNumber(int m, int n) {
        return m > 0 && n > 0;
    }

    static int[] divider(int d) {
        int[] dividers = new int[d]; // Создаем массив для хранения делителей
        int count = 0; // Счетчик для индексации массива

        for (int i = 2; i <= d; i++) {
            if (d % i == 0) {
                dividers[count] = i;
                count++;
            }
        }

        int[] result = Arrays.copyOf(dividers, count); // Создаем массив нужного размера
        return result;
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
        if (!conditionNumber(m, n)) {
            return -1;
        }

        int lcm = (m * n) / getGcd(m, n);

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
        // Ваш код

        if (!conditionNumber(m, n)) {
            return -1;
        }

        int[] dividersM = divider(m);
        int[] dividersN = divider(n);
        int gcd = 1;

        for (int i = 0; i < dividersM.length; i++) {
            for (int j = 0; j < dividersN.length; j++) {
                if (dividersM[i] == dividersN[j] && dividersM[i] > gcd) {
                    gcd = dividersM[i];
                }
            }
        }

        return gcd;
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
        if (!conditionNumber(m, n)) {
            return -1;
        }

        int d = Math.max(m, n) % Math.min(m, n);


        return d;
    }
}
