package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        //System.out.println(getGcd(12, 9));
        //System.out.println(getLcm(12,9));
        System.out.println(getGcdByEuclideanAlgorithm(48, 18));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (isInputDataIncorrect(m, n)) {
            return -1;
        }

        int maxOfTwoDigits = Math.max(m, n);
        for (int i = 1; i <= maxOfTwoDigits; i++){
            int multipleNumber = maxOfTwoDigits * i;
            if (multipleNumber % m == 0 && multipleNumber % n == 0){
                return multipleNumber;
            }
        }
        return 0;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (isInputDataIncorrect(m, n)) {
            return -1;
        }

        int minOfTwoDigits = Math.min(m, n);

        for (int i = minOfTwoDigits; i > 0; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 0;
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
        if (isInputDataIncorrect(m, n)) {
            return -1;
        }

        if (n == 0) {
            return m;
        }
            return getGcdByEuclideanAlgorithm(n, m % n);
    }

    static boolean isInputDataIncorrect(int m, int n) {
        return m <= 0 || n < 0;
    }
}
