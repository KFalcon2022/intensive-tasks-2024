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
    }

    static boolean isIncorrectData(int m, int n) {
        return m < 0 || n < 0;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (isIncorrectData(m, n) || m == 0 || n == 0) {
            return -1;
        }

        if (Math.max(m, n) % Math.min(m, n) == 0) { //обработка случая кратных чисел, быстрее вычисления через НОД
            return Math.max(m, n);
        }

        return m * n / getGcdByEuclideanAlgorithm(m, n); //по формуле НОК = a*b/НОД(a,b);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (isIncorrectData(m, n) || m == 0 || n == 0) {
            return -1;
        }

        if (Math.max(m, n) % Math.min(m, n) == 0) {
            return Math.min(m, n);
        }

        return getGcd(Math.max(m, n) - Math.min(m, n), Math.min(m, n));
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
        if (n == 0) {
            return m;
        }

        return getGcdByEuclideanAlgorithm(n, m % n);
    }
}
