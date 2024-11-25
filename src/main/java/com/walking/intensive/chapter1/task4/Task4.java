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
        double a = 2;
        double b = 0;
        double c = 0;
        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        double discr = Math.pow(b, 2) - 4 * a * c;

        if (discr < 0 || a == 0 && b == 0) {
            return "Количество решений: 0.";
        }

        if (discr == 0) {
            double root = -b / (2 * a);
            root = root == -0 ? 0 : root;
            return "Количество решений: 1. Корень: " + Double.toString(root);
        }

        if (a == 0) {
            return "Количество решений: 1. Корень: " + String.valueOf(-c / b);
        }

        double x1 = (-b + Math.sqrt(discr)) / 2 * a;
        double x2 = (-b - Math.sqrt(discr)) / 2 * a;

        return "Количество решений: 2. Корни: " + String.valueOf(Math.min(x1, x2)) + ";"
                + String.valueOf(Math.max(x1, x2));
    }
}
