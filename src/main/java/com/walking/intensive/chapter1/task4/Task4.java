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
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        //        Место для вашего кода

        // Проверка на наличие корней
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "Бесконечное множество решений.";
                } else {
                    return "Количество решений: 0.";
                }
            } else {
                double singleRoot = -c / b;
                return String.format("Количество решений: 1. Корень: %.1f", singleRoot);
            }
        }

        double discriminantValue = Math.pow(b, 2) - 4 * a * c;

        // Два корня
        if (discriminantValue > 0) {
            double firstRoot = (-b - Math.sqrt(discriminantValue)) / (2 * a);
            double secondRoot = (-b + Math.sqrt(discriminantValue)) / (2 * a);
            return String.format("Количество решений: 2. Корни: %.1f;%.1f",
                    Math.min(firstRoot, secondRoot),
                    Math.max(firstRoot, secondRoot));
        }
        // Один корень
        else if (discriminantValue == 0) {
            double singleRoot2 = -b / (2 * a);
            return String.format("Количество решений: 1. Корень: %.1f", formatCase(singleRoot2));
        } else {
            return "Количество решений: 0.";
        }
    }

    // Заменяем -0.0 на 0.0
    private static double formatCase(double specialCase) {
        return specialCase == -0.0 ? 0.0 : specialCase; // тернарный оператор
    }
}
