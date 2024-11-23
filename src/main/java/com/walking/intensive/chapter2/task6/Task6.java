package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println(getLcm(66, 87));
        System.out.println(getGcd(119, 544));
        System.out.println(getGcdByEuclideanAlgorithm(17, 49));
        System.out.println(getGcdByEuclideanAlgorithmByRecursion(15, 25));
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

        if (m > n) {
            int temp = n;
            n = m;
            m = temp;
        }

        int nod = 1;

        while (m > 1 && n > 1) {
            for (int i = 2; i <= m; i++) {
                if (m % i == 0 && n % i == 0) {
                    nod *= i;
                    m /= i;
                    n /= i;
                }

                if (m % i == 0) {
                    m /= i;
                    break;
                }

                if (n % i == 0) {
                    n /= i;
                    break;
                }
            }
        }

        return nod;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
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

        if (m == n) {
            return m;
        }

        while (m != n) {
            if (m > n) {
                m -= n;
            }
            if (m < n) {
                n -= m;
            }
        }

        return m;
    }

    static int getGcdByEuclideanAlgorithmByRecursion(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        if (m == n) {
            return m;
        }

        return m > n ? getGcdByEuclideanAlgorithmByRecursion(m - n, n)
                : getGcdByEuclideanAlgorithmByRecursion(n, n - m);
    }
}
