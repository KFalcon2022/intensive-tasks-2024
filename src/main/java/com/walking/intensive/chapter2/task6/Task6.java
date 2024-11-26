package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе\
        int m = 5;
        int n = 6;
        System.out.println("НОК = " + getLcm(m, n));
        System.out.println("НОД = " + getGcd(m, n));
        System.out.println("НОД2 = " + getGcdByEuclideanAlgorithm(m, n));
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

        int maxNumber = Math.max(m, n);
        int minNumber = Math.min(m, n);
        int lcm = maxNumber;

        while (true) {

            if (lcm % minNumber == 0) {
                return lcm;
            }

            lcm += maxNumber;
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

        if (m % n == 0 || n % m == 0) {
            return Math.min(m, n);
        }

        int minNumber = Math.min(m, n);
        int maxNumber = Math.max(m, n);
        int gcd = 1;
        int i = 2;

        while (i <= (minNumber / 2)) {

            if (maxNumber % i == 0 && minNumber % i == 0) {
                gcd *= i;
                maxNumber /= i;
                minNumber /= i;
            } else {
                i = i == 2 ? i + 1 : i + 2;
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

        if (m < 1 || n < 1) {
            return -1;
        }

        return getGcdByEuclideanAlgorithmHelper(n, m % n);
    }

    static int getGcdByEuclideanAlgorithmHelper(int m, int n) {

        return n == 0 ? m : (getGcdByEuclideanAlgorithmHelper(n, m % n));
    }
}
