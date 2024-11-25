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

        return (m * n) / getGcdByEuclideanAlgorithm(m, n);
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

        int divisor = Math.min(m, n) / 2;

        while (m % divisor != 0 || n % divisor != 0) {
            divisor--;
        }

        return divisor;
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
         /*
         Для валидации n == 0 ? предложил бы ввести в параметры метода boolean isOriginalNumbers
         и вызов метода из main c true
         и тогда делал бы проверку: if (isOriginalNumbers && ( m < 1 || n < 1)) return -1;
         а в рекурсии бы параметром шел бы false и до проверки n не дошли бы
         */

        if (m < 1 || n < 0) {
            return -1;
        }

        return n == 0 ? m : (getGcdByEuclideanAlgorithm(n, m % n));
    }
}
