package com.walking.intensive.chapter1.task4;

import static java.lang.Math.*;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {
        double a = 1;
        double b = 10;
        double c = -80;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (b == 0 && c == 0) {
            return "Количество решений: 1. Корень: 0";
        }

        if (a == 0) {
            if (b == 0) {
                return "Количество решений: 0.";
            }

            return "Количество решений: 1. Корень: %d".formatted((int) (-c / b));
        }

        if (b == 0) {
            if (-c / a < 0) {
                return "Количество решений: 0.";
            }

            int rootOne = (int) sqrt(-c / a);
            int rootTwo = -(int) sqrt(-c / a);

            return "Количество решений: 2. Корни: %d;%d".formatted(rootTwo, rootOne);
        }

        if (c == 0) {
            return "Количество решений: 2. Корни: 0;%d".formatted((int) (-b / a));
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return "Количество решений: 0.";
        } else if (discriminant == 0) {
            return "Количество решений: 1. Корень: %d".formatted((int) (-b / 2 * a));
        }

        int rootOne = (int) ((-b + sqrt(discriminant)) / 2 * a);
        int rootTwo = (int) ((-b - sqrt(discriminant)) / 2 * a);

        return "Количество решений: 2. Корни: %d;%d".formatted(min(rootOne, rootTwo), max(rootOne, rootTwo));
    }
}
