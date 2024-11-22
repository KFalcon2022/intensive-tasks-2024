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

        double discriminant;

        discriminant = (b * b) - 4 * a * c;

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (discriminant < 0 || (a == 0 && b == 0)) {
            return "Количество решений: 0.";
        }

        if (discriminant == 0) {
            return "Количество решений: 1. Корень: " + Math.abs(-b / (2 * a));
        }

        double rootOne;
        double rootSecond;

        if (discriminant > 0) {

            if (a == 0) {
                return "Количество решений: 1. Корень: " + (-c / b);
            }

            rootOne = (-b - Math.sqrt(discriminant)) / (2 * a);
            rootSecond = (-b + Math.sqrt(discriminant)) / (2 * a);

            if (rootOne > rootSecond) {
                return "Количество решений: 2. Корни: " + rootSecond + ";" + rootOne;
            }
            return "Количество решений: 2. Корни: " + rootOne + ";" + rootSecond;
        }

        return "Ошибка ввода";
    }
}
