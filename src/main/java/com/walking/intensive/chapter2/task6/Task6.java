package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {

        System.out.println(getLcm(8, 6));
        System.out.println();
        System.out.println(getGcd(18, 38));
        System.out.println();
        System.out.println(getGcdByEuclideanAlgorithm(38, 18));
    }

    static boolean validate(int m, int n) {

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

        if (validate(m, n)) {
            return -1;
        }

        int noc = 0;
        int number1 = m;
        int number2 = n;

        if (number1 == number2) {
            noc = number1;
            return noc;
        }

        while (number1 != number2) {
            if (number1 < number2) {
                number1 += m;
            } else {
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

        if (validate(m, n)) {
            return -1;
        }

        int nod = 0;

        for (int i = 1; i <= m; i++) {
            if (m % i == 0 && n % i == 0) {
                nod = i;
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
