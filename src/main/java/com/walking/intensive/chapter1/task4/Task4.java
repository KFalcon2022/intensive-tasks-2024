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
        double b = -4;
        double c = 4;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода
        double x1 = 0.0;
        double x2 = 0.0;
        double x = 0.0;
        double d;
        d = (b * b) - ((4 * a) * c);
        // x1 / x2 = -b / a;
        // x2 * x2 = c / a;

        if (d > 0) {
            double e = Math.sqrt(d);
            x1 = (-b + e) / (2 * a);
            x2 = (-b - e) / (2 * a);
            if (x1 > x2) {
                return d + "Количество решений: 2." + " Корни: " + x2 + "; " + x1;
            } else {
                return d + "Количество решений: 2." + " Корни: " + x1 + "; " + x2;
            }

        } else if (d == 0) {
            x = -b / 2 * a;
            return d + "количество решений: 1 " + x;
        }

        return d + "нет корней";
    }
}
