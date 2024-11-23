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
        int n = 20;
        int m = 4;
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


    }

        /**
         * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
         *
         * <p>Входные параметры - положительные целые числа.
         *
         * <p>Если входные данные некорректны - метод должен возвращать -1.
         */
        static int getGcd ( int m, int n){
            // Ваш код
            return 0;
        }

        /**
         * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
         * Расчет должен производиться с помощью алгоритма Евклида
         *
         * <p>Входные параметры - положительные целые числа.
         *
         * <p>Если входные данные некорректны - метод должен возвращать -1.
         */
        static int getGcdByEuclideanAlgorithm ( int m, int n){
            // Ваш код
            return 0;
        }
    }
