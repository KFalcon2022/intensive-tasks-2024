package com.walking.intensive.chapter1.task4;

/**
 * Дано уравнение:
 *
 * <p>ax? + bx + c = 0
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
        double a = 2;
        double b = -5;
        double c = 3;

        System.out.println(solveQuadraticEquation(a, b, c));
    }

    static String solveQuadraticEquation(double a, double b, double c) {

        String textMessage = "Количество решений: ";
        double discriminantValue = b * b - 4 * a * c;

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное количество решений";
        } else if (a == 0 && b == 0 && c != 0) {
            return "Решений нет";
        } else if (a == 0 && b != 0) {
            return "x = -c/b";
        }

        if (discriminantValue > 0) {
            double firstValue = (-b - Math.sqrt(discriminantValue)) / (2 * a);
            double secondValue = (-b + Math.sqrt(discriminantValue)) / (2 * a);
            textMessage = textMessage + "2. Корни: " + firstValue + "; " + secondValue;
        } else if (discriminantValue == 0) {
            double firstValue = (-b - Math.sqrt(discriminantValue)) / (2 * a);
            textMessage = textMessage + "1. Корень: " + firstValue;
        } else {
            textMessage = textMessage + "0.";
        }

        return textMessage;
    }
}