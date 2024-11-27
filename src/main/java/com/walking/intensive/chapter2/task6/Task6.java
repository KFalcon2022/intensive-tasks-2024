package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {

        System.out.println(getGcd(38, 18));
        System.out.println();
        System.out.println(getGcdByEuclideanAlgorithm(38, 18));
    }

    static boolean getValidation(int m, int n) {

        return m <= 0 || n <= 0;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        if (getValidation(m, n)) {
            return -1;
        }

        int noc = 0, number1 = m, number2 = n;

        if (number1 == number2) {
            noc = number1;
            return noc;
        }

        while (number1 != number2) {
            while (number1 < number2) {
                number1 += m;
            }
            while (number1 > number2) {
                number2 += n;
            }

            noc = number1;
        }

        return noc;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        if (getValidation(m, n)) {
            return -1;
        }

        int nod = 0, number1 = 0, number2 = 0;

        for (int i = 1; i <= m; i++) {
            if (m % i == 0) {
                number1 = i;
            }
            for (int j = 1; j <= n; j++) {
                if (n % j == 0) {
                    number2 = j;

                    if (number1 == number2) {
                        nod = number1;
                    }
                }
            }
        }

        return nod;
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

        if (m <= 0) {
            return -1;
        }

        if (n == 0) {
            return m;
        }

        return getGcdByEuclideanAlgorithm(n, m % n);
    }
}
