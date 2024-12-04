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
        int m = 45;
        int n = 80;
        System.out.println(getLcm(m, n));
        System.out.println(getGcd(m, n));
        System.out.println(getGcdByEuclideanAlgorithm(m, n));
    }

    static boolean isConditionNumber(int m, int n) {
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
        // Ваш код
        if (!isConditionNumber(m, n)) {
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
        // Ваш код
        if (!isConditionNumber(m, n)) {
            return -1;
        }

        int gcd = 1;

        for (int i = Math.min(m, n); i > 0; i--) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
                break;
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
        int remainder = m % n;

        if (remainder == 0) {
            return n;
        }

        return getGcdByEuclideanAlgorithm(n, remainder);
    }
}
