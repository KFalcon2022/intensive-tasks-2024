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
        double a = 2;
        double b = 5;
        double c = -3;
        System.out.println(solveEquation(a, b, c));

        double number1 = 0.5;
        System.out.println(number1 % 1 == 0 ? (Object) (int) number1 : number1);

    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? "Бесконечное множество решений." : "Количество решений: 0.";
            } else {
                double result = -c / b;
                return "Количество решений: 1. Корень: " + formatNumber(result);
            }
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double sqrtDiscriminant = Math.sqrt(discriminant);

            double root1 = (-b - sqrtDiscriminant) / (2 * a);
            double root2 = (-b + sqrtDiscriminant) / (2 * a);

            double min = Math.min(root1, root2);
            double max = Math.max(root1, root2);

            return "Количество решений: 2. Корни: " + formatNumber(min) + ";" + formatNumber(max);
        } else if (discriminant == 0) {
            double result = -b / (2 * a);
            return "Количество решений: 1. Корень: " + formatNumber(result);
        } else {
            return "Количество решений: 0.";
        }
    }

    private static Object formatNumber(double number) {
        return number % 1 == 0 ? (Object) (int) number : number;
    }
}
