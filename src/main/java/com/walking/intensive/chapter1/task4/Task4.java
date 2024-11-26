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
        double a = 0;
        double b = -2;
        double c = 4;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода
        double discriminant = (b * b) - (4 * a * c);
        int num = 0;
        if (a == 0 && b == 0 && c == 0){
            return "Бесконечное множество решений.";
        }
        if (a == 0 && b != 0 && c!= 0) {
            double koren = (-c) / b;
            return String.valueOf("Количество решений: 1. Корень: " + koren);
        }
        if (a != 0 && b == 0 && c == 0) {
            return String.valueOf("Количество решений: 1. Корень: 0");
        }
        if (discriminant < 0 || a == 0 && b == 0) {
            return String.valueOf("Количество решений: 0.");
        }
        if (discriminant == 0 || a == 0) {
            num = 1;
        }
        if (discriminant >= 0) {
            num = 2;
        }
        var sqrtDis = Math.pow(discriminant, 0.5);
        var x1 = (-b + sqrtDis) / (2 * a);
        var x2 = (-b - sqrtDis) / (2 * a);
        //return String.format("%d дискриминант - %d корень из д, %d х1, %d х2", discriminant, sqrtDis, x1, x2);// Заглушка. При реализации - удалить
        //return String.valueOf("Количество решений: " + discriminant + "," + sqrtDis);
        return String.valueOf("Количество решений: " + num + ". Корни: " + x1 + ";" + x2 + "," + discriminant);
    }
}
