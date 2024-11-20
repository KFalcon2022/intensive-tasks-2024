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
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));
        System.out.println(solveEquation(-1, 3, 4));
    }

    static String solveEquation(double a, double b, double c) {

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (a == 0 && b == 0) {
            return "Количество решений: 0.";
        }

        if (a == 0) {
            int x1 = (int) (-c / b);
            return "Количество решений: 1. Корень: " + x1;
        }

        double discriminant = b * b - 4 * a * c;

        return getResult(a, b, discriminant);

    }

    private static String getResult(double a, double b, double discriminant) {

        String result;

        if (discriminant < 0) {
            result = "Количество решений: 0.";
        } else if (discriminant == 0) {
            int x1 = (int) (-b / (2 * a));
            result = "Количество решений: 1. Корень: " + x1;
        } else {
            int x1 = (int) ((-b + Math.sqrt(discriminant)) / (2 * a));
            int x2 = (int) ((-b - Math.sqrt(discriminant)) / (2 * a));
            result = "Количество решений: 2. Корни: " + Math.min(x1, x2) + ";" + Math.max(x1, x2);
        }

        return result;
    }
}
