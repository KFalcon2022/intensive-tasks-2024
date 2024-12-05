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
        double b = -14;
        double c = -5;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода

        double discrDouble = (Math.pow(b,2)) - (4 * a * c);

        if (discrDouble < 0) {
            return"Kolichestvo resheniy: 0.";
        }
        else if (discrDouble == 0) {
            return("Kolichestvo resheniy: 1. Koren': " + (-b / 2 * a));
        }
        else if (discrDouble > 0) {
            double x1 = (-b - Math.sqrt(discrDouble)) / (2 * a);
            double x2 = (-b + Math.sqrt(discrDouble)) / (2 * a);
            if (x1 > x2) {
                return("Kolichestvo resheniy: 2. Korni: " + x2 + "; " + x1);
            }
            else {
                return("Kolichestvo resheniy: 2. Korni: " + x1 + "; " + x2);
            }
        }

        return null; // Заглушка. При реализации - удалить
    }
}
