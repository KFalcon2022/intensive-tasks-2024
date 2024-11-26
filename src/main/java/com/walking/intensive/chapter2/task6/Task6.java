package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println("lcm=" + getLcm(60, 420));
        System.out.println("gcd=" + getGcd(415 , 215));
        System.out.println("gcdByEuclideanAlgorithm=" + getGcdByEuclideanAlgorithm(0 , 20));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (m < 1 || n < 1) {
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
        if (m < 1 || n < 1) {
            return -1;
        }
        int gcd = 1;
        int biggerNumber = m >= n ? m : n;

        for (int i = biggerNumber; i >= 1; i--) {
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
        if (m < 1 || n < 1) {
            return -1;
        }

        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }

        return m;
    }
}
