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
        double b = 5;
        double c = 2;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода
        double d = 0;
        double x1, x2;
        String result = "";

        d = b * b - 4 * a * c;
        if (d > 0){
            x1 = ((-1 * b) + Math.sqrt(d)) / (2 * a);
            x2 = ((-1 * b) - Math.sqrt(d)) / (2 * a);
            if (x1 > x2){
                result = "Количество решений: 2 " + x2 + ";" + x1;
            }
            else {
                result = "Количество решений: 2 " + x1 + ";" + x2;
            }
        }
        else if (d == 0) {
            x1 = (-1 * b) / 2 * a;
            result = "Количество решений: 1" + x1;
        }
        else if (d <0){
            result = "Количество решений: 0";
        }

        return result; // Заглушка. При реализации - удалить
    }
}
