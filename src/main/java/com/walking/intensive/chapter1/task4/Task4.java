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
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 0;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {

        Locale.setDefault(Locale.US);

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        double d = b * b - 4 * a * c;

        if (d < 0 || (a == 0 && b == 0)) {
            return "Количество решений: 0.";
        }

        double epsilon = 0.00001;

        if (Math.abs(d) < epsilon || a == 0) {
            double root;
            if (a == 0) {
                root = (0 - c) / b;
            } else {
                root = (0 - b) / (2 * a);
            }
            return "Количество решений: 1. Корень: %.1f".formatted(root);
        }

        double firstRoot = (0 - b - Math.sqrt(d)) / (2 * a);
        double secondRoot = (Math.sqrt(d) - b) / (2 * a);

        if (firstRoot > secondRoot) {
            double temp = firstRoot;
            firstRoot = secondRoot;
            secondRoot = temp;
        }

        return "Количество решений: 2. Корни: %.1f;%.1f".formatted(firstRoot, secondRoot);
    }
}
