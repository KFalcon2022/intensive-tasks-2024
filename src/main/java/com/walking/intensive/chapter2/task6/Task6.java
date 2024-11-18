package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println(getGcd(8, 12));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (isInvalidNumbers(m, n)) {
            return -1;
        }

        int lcm = Math.max(m, n);

        while (true) {
            if (lcm % m == 0 && lcm % n == 0) {
                return lcm;
            }
            lcm++;
        }
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (isInvalidNumbers(m, n)) {
            return -1;
        }

        int gcd = 1;

        int limit = Math.min(m, n);

        for (int i = 1; i <= limit; i++) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (isInvalidNumbers(m, n)) {
            return -1;
        }

        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    private static boolean isInvalidNumbers(int m, int n) {
        return m <= 0 || n <= 0;
    }
}
