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
        System.out.println(getLcm2(15, 25));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        if (!isValidParams(m, n)) {
            return -1;
        }

        return n * m / getGcd(m, n);
    }

    //Опционально. Поиск НОК без использования НОД
    static int getLcm2(int m, int n) {

        if (!isValidParams(m, n)) {
            return -1;
        }

        int maxNum = Math.max(m, n);
        int minNum = Math.min(m, n);
        int lcm = maxNum;

        while (lcm % minNum != 0) {
            lcm += maxNum;
        }
        return lcm;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        if (!isValidParams(m, n)) {
            return -1;
        }

        while (m != 0) {
            int tmp = m;
            m = n % m;
            n = tmp;
        }

        return n;
    }

    //Опционально
    static int getGcd2(int m, int n) {

        if (!isValidParams(m, n)) {
            return -1;
        }

        int maxNum = Math.max(m, n);
        int minNum = Math.min(m, n);

        if (maxNum - minNum == 0) {
            return minNum;
        }
        return getGcd2(maxNum - minNum, minNum);
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

        if (m < 1) {
            return -1;
        }

        if (n == 0) {
            return m;
        }

        return getGcdByEuclideanAlgorithm(n, m % n);
    }

    static boolean isValidParams(int m, int n) {
        return (m > 0 && n > 0);
    }
}
