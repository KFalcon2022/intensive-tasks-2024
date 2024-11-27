package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        //System.out.println(getLcm(30, 18));
        System.out.println(getGcdByEuclideanAlgorithm(30, 18));
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

        if (m <= 0 || n <= 0) {
            return -1;
        }

        int minValue = Math.min(m, n);
        int maxValue = Math.max(m, n);

        while (maxValue % minValue != 0) {
            int modValue = maxValue % minValue;
            maxValue = minValue;
            minValue = modValue;
        }

        return minValue;
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

        int minValue = Math.min(m, n);
        int modValue = Math.max(m, n) % minValue;

        if (modValue == 0) {
            return minValue;
        }

        return getGcdByEuclideanAlgorithm( minValue, modValue );
    }
}
