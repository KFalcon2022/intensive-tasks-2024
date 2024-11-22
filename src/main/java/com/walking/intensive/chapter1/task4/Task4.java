package com.walking.intensive.chapter1.task4;

import java.util.Locale;

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

        double a = 0;
        double b = 4;
        double c = 0;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        Locale.setDefault(Locale.ENGLISH);

        String resultString;
        double x1;
        double x2;
        double D = Math.pow(b, 2) - 4 * a * c;

        if (a == 0 && b == 0 && c == 0) {
            resultString = "Бесконечное множество решений.";
        } else if (a == 0 && b != 0) {
            resultString = "Количество решений: 1. Корень: " + getPrettyNull(-c / b);
        } else if (a == 0 || D < 0) {
            resultString = "Количество решений: 0.";
        } else if (D == 0) {
            resultString = "Количество решений: 1. Корень: " + getPrettyNull(-b / (2 * a));
        } else {
            x1 = getPrettyNull((-b + Math.sqrt(D)) / (2 * a));
            x2 = getPrettyNull((-b - Math.sqrt(D)) / (2 * a));
            resultString = String.format("Количество решений: 2. Корни: %1$.1f;%2$.1f", Double.min(x1, x2), Double.max(x1, x2));
        }
        return resultString;
    }

    //костыль для избавления от -0.0
    static double getPrettyNull(double a) {
        if (a == -0.0) {
            return 0.0;
        } else {
            return a;
        }
    }
}