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
    static final String ENDLESS_SOLUTIONS = "Бесконечное множество решений.";
    static final String ZERO_SOLUTIONS = "Количество решений: 0.";
    static final String ONE_SOLUTIONS = "Количество решений: 1. Корень: ";
    static final String TWO_SOLUTIONS = "Количество решений: 2. Корни: ";

    public static void main(String[] args) {
        double a = 1;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {

        if (a == 0) {
            if (b == 0) {
                return c == 0 ? ENDLESS_SOLUTIONS : ZERO_SOLUTIONS;
            }
            return ONE_SOLUTIONS + (-c / b);
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return ZERO_SOLUTIONS;
        }

        if (discriminant == 0) {
            double root = -b / 2 * a;
            return ONE_SOLUTIONS + (root == -0 ? 0 : root);
        }

        double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
        double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);

        return TWO_SOLUTIONS + (Math.min(firstRoot, secondRoot)) + ";" + (Math.max(firstRoot, secondRoot));
    }
}
