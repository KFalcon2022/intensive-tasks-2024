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
        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        String numberOfAnswers = "Количество решений: %d.";

        double discriminant = (b * b) - 4 * a * c;
        if (discriminant < 0  || (a == 0 && b == 0)) {
            return numberOfAnswers.formatted(0);
        }

        if (a == 0 || discriminant == 0) {
            double x;
            if (a == 0) {
                x = -c / b;
            } else {
                if (b == 0) {
                    x = 0.0;
                } else {
                    x = -b / (2 * a);
                }
            }
            return String.format(Locale.ROOT, numberOfAnswers.formatted(1) + " Корень: %.1f", x);
        }

        double x1 = (- b + Math.sqrt(discriminant)) / (2 * a);
        double x2 = (- b - Math.sqrt(discriminant)) / (2 * a);
        return String.format(Locale.ROOT, numberOfAnswers.formatted(2) +
                " Корни: %.1f;%.1f", Double.min(x1, x2), Double.max(x1, x2));
    }
}