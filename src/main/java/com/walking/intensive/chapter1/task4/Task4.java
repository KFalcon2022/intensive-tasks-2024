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
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 0;
        double b = 2;
        double c = -2;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        double D;

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        } else if (a == 0 && b == 0) {
            return "Количество решений: 0.";
        } else if (a == 0) {
            double root = (-c / b);
            if (root == -0.0) {
                return "Количество решений: 1. Корень: " + 0.0;
            } else {
                return "Количество решений: 1. Корень: " + root;
            }
        }

        double firstRoot;
        double secondRoot;

        // find D
        D = b * b - 4 * a * c;

        // find roots
        if (D < 0) {
            return "Количество решений: 0.";
        } else if (D == 0) {
            firstRoot = (-b - Math.sqrt(D)) / 2 * a;
            firstRoot = firstRoot == 0 ? 0.0 : firstRoot;

            return "Количество решений: 1. " + "Корень: " + firstRoot;
        } else
            firstRoot = (-b - Math.sqrt(D)) / 2 * a;
            secondRoot = (-b + Math.sqrt(D)) / 2 * a;

            String roots;
            if (firstRoot < secondRoot) {
                roots = firstRoot + ";" + secondRoot;
            } else roots = secondRoot + ";" + firstRoot;

            return "Количество решений: 2. " + "Корни: " + roots;
    }
}
