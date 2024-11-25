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
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 3;
        double b = 7;
        double c = -10;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода
        double discriminant = b * b - 4 * a * c;
        // sqrtDis = Math.pow(discriminant, 0.5);
        //System.out.println(discriminant, sqrtDis);
        //var s = discriminant;
        //return String.format("%d кв - %d подъезд " + discriminant, sqrtDis);// Заглушка. При реализации - удалить
        return String.valueOf(discriminant);
    }
}
