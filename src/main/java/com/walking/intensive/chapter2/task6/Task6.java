package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getLcm(12, 24));
        System.out.println(getGcd(6, 8));
        System.out.println(getGcdByEuclideanAlgorithm(36, 14));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (incorrectInputValidation(m, n)) {
            return -1;
        }

        int gcd = getGcd(m, n);

        return m / gcd * n;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (incorrectInputValidation(m, n)) {
            return -1;
        }

        int gcd = 1;
        int smallerNumber = Math.min(m, n);

        for (int i = 1; i <= smallerNumber; i++) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
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
        if (incorrectInputValidation(m, n)) {
            return -1;
        }

        if (n == 0) {
            return m;
        }

        return getGcdByEuclideanAlgorithm(n, m % n);
    }

    static boolean incorrectInputValidation(int m, int n) {

        return (m <= 0 || n < 0);
    }
}
