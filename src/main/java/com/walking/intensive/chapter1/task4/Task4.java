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
        double a = 3;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (a == 0 && b != 0 && c != 0) {
            return "Количество решений: 1. Корень: " + (-c / b);
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0 || (a == 0 && b == 0)) {   //включает ур-е с = 0, где с отлично от нуля
            return "Количество решений: 0.";
        }

        if (discriminant == 0) {
            if (b == 0) {         //чтобы не было знака "-" у нуля в ответе, если b = 0
                b = -b;
            }
            return "Количество решений: 1. Корень: " + (-b) / (2 * a);
        }

        double root1 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b + Math.sqrt(discriminant)) / (2 * a);

        if (root1 < root2) {
            return "Количество решений: 2. Корни: " + root1 + ";" + root2;
        }

        return "Количество решений: 2. Корни: " + root2 + ";" + root1;
    }
}
