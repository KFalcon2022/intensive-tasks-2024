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
        double a = -1;
        double b = 3;
        double c = 4;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        boolean isSqrt = (a != 0 && b != 0 && c != 0);
        boolean isNonSqrtFirst = (a == 0 && b != 0 && c != 0);
        boolean isNonSqrtSecond = ((a == 0 && b != 0 && c == 0) || (a != 0 && b == 0 && c == 0));
        boolean isZero = (a == 0 && b == 0 && c == 0);

        if (isSqrt) {
            final double discriminant = Math.pow(b, 2) - (4 * a * c);
            double xFirst = 0;
            double xSecond = 0;
            if (discriminant > 0) {
                xFirst = (-(b) + Math.sqrt(discriminant)) / 2 * a;
                xSecond = (-(b) - Math.sqrt(discriminant)) / 2 * a;
                if (xFirst < xSecond) {
                    return "Количество решений: 2. Корни: " + xFirst + ";" + xSecond;
                } else {
                    return "Количество решений: 2. Корни: " + xSecond + ";" + xFirst;
                }
            } else if (discriminant == 0) {
                xFirst = (-b) / 2 * a;
                return "Количество решений: 1. Корень: " + xFirst;
            }
            return "Количество решений: 0.";
        } else if (isNonSqrtFirst) {
            return "Количество решений: 1. Корень: " + ((c / b) * (-1));
        } else if (isNonSqrtSecond) {
            return "Количество решений: 1. Корень: 0";
        } else if (isZero) {
            return "Бесконечное множество решений.";
        }
        return "Количество решений: 0.";
    }
}
