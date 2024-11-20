package com.walking.intensive.chapter1.task4;

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
        double b = -2;
        double c = 2;
        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        } else if (a == 0 && b == 0) {
            return "Количество решений: 0.";
        } else if (a == 0) {
            double root = -c / b;
            return "Количество решений: 1. Корень: " + formatRoot(root);
        }

        double discriminantValue = b * b - 4 * a * c;

        if (discriminantValue > 0) {
            double root1 = (-b - Math.sqrt(discriminantValue)) / (2 * a);
            double root2 = (-b + Math.sqrt(discriminantValue)) / (2 * a);
            return "Количество решений: 2. Корни: " + formatRoot(Math.min(root1, root2)) + ";" + formatRoot(Math.max(root1, root2));
        } else if (discriminantValue == 0) {
            double root = -b / (2 * a);
            return "Количество решений: 1. Корень: " + formatRoot(root);
        } else {
            return "Количество решений: 0.";
        }
    }

    static String formatRoot(double root) {
        if (root == (int) root) {
            return String.valueOf((int) root);
        } else {
            return String.valueOf(root);
        }
    }
}
