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
        double b = 0;
        double c = 0;
        System.out.println(solveEquation(5, -2, 1));
    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "Бесконечное множество решений.";
                } else {
                    return "Количество решений: 0.";
                }
            } else {
                double root = -c / b;
                return String.format("Количество решений: 1. Корень: %.6f", root);
            }
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);

            if (x1 > x2) {
                double temp = x1;
                x1 = x2;
                x2 = temp;
            }
            return String.format("Количество решений: 2. Корни: %.6f;%.6f", x1, x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            return String.format("Количество решений: 1. Корень: %.6f", x);
        } else {
            return "Количество решений: 0.";
        }
    }
}
