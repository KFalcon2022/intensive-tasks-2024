package com.walking.intensive.chapter2.task6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int m = in.nextInt();
        System.out.print("Введите второе число: ");
        int n = in.nextInt();

        System.out.println("НОК = " + getLcm(m, n));

    }

    static int getLcm(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int x = m;
        while (m % n != 0) {
            m += x;
        }
        return m;
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
        // Ваш код
        return 0;
    }
}
