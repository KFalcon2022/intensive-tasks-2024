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
        double a = 1;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {

        double d = Math.pow(b, 2) - 4 * (a * c);
        double disSqrt = Math.pow(d, 0.5);

        if (a == 0 && b == 0) {
            if (c == 0) {
                return "Бесконечное множество решений";
            }
            return "Некорректные входные данные";
        }

        if (a == 0) {
            double x = -c / b;
            return String.format("Количество решений: 1. Корень: %.0f", x);
        }

        if ((a == 0 && b == 0) || d < 0) {
            return "Количество решений: 0.";
        }

        if (d == 0) {
            double x1;
            if (b == 0) {
                x1 = 0;
            } else {
                x1 = -b / (2 * a);
            }
            return String.format("Количество решений: 1. Корень: %.0f", x1);
        }

        double root1 = (-b + disSqrt) / (2 * a);
        double root2 = (-b - disSqrt) / (2 * a);

        if (root1 > root2) {
            return String.format("Количество решений: 2. Корни: %.0f;%.0f", root1, root2);
        }
        return String.format("Количество решений: 2. Корни: %.0f;%.0f", root2, root1);
    }
}




