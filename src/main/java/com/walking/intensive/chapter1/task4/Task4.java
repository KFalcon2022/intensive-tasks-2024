package com.walking.intensive.chapter1.task4;

import static java.lang.Math.sqrt;

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

        double Discriminant = b * b - 4 * a * c;

        if (Discriminant < 0 || (a == 0 && b == 0)) {
            return "Количество решений: 0.";
        }

        double OneSolution;

        if (a == 0) {
            OneSolution = -c / b;
            return "Количество решений: 1. Корень: " + OneSolution;
        }

        if (Discriminant == 0) {
            if (b != 0 && c != 0) {
                OneSolution = -b / (2 * a);
                return "Количество решений: 1. Корень: " + OneSolution;
            }
            OneSolution = b / (2 * a);
            return "Количество решений: 1. Корень: " + OneSolution;
        }

        double Solution1;
        double Solution2;
        Solution1 = -(b + sqrt(Discriminant)) / (2 * a);
        Solution2 = -(b - sqrt(Discriminant)) / (2 * a);

        if (Solution1 > Solution2) {
            return "Количество решений: 2. Корни: " + Solution2 + ";" + Solution1;
        }
        return "Количество решений: 2. Корни: " + Solution1 + ";" + Solution2;
    }
}
