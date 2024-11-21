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
        double a = 1;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {

        if (a != 0) {
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = -1 * b / a / 2 + Math.sqrt(discriminant) / a / 2;
                root1 = root1 == 0.0 ? Math.abs(root1) : root1;
                double root2 = -1 * b / a / 2 - Math.sqrt(discriminant) / a / 2;
                root2 = root2 == 0.0 ? Math.abs(root2) : root2;

                return String.format(Locale.US, "Количество решений: 2. Корни: %,.1f;%,.1f",
                        Math.min(root1, root2), Math.max(root1, root2));
            }

            if (discriminant < 0) {
                return "Количество решений: 0.";
            }

            double root1 = -1 * b / a / 2;
            root1 = root1 == 0.0 ? Math.abs(root1) : root1;
            return String.format(Locale.US, "Количество решений: 1. Корень: %,.1f", root1);
        }

        if (b == 0 && c != 0) {
            return "Количество решений: 0.";
        }

        if (b != 0) {
            double root1 = -1 * c / b;
            root1 = root1 == 0.0 ? Math.abs(root1) : root1;
            return String.format(Locale.US, "Количество решений: 1. Корень: %,.1f", root1);
        }

        return "Бесконечное множество решений.";
    }
}
