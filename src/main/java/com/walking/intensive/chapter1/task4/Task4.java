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
 * <li> "Количество решений: 0"
 * <li> "Бесконечное множество решений"
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>Если с указанными коэффициентами уравнение некорректно - метод должен вернуть строку
 * "Некорректные входные данные".
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

        double root1, root2;
        double discriminant = b * b - 4 * a * c;

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (b == 0 && (a == 0 || (-c / a) < 0) || discriminant < 0) {
            return "Количество решений: 0.";
        }

        if (b == 0) {
            root1 = 0;
            return "Количество решений: 1. Корень: " + root1;
        }

        if (a == 0 || discriminant == 0) {
            root1 = a == 0 ? -c / b : -b / (2 * a);
            return "Количество решений: 1. Корень: " + root1;
        }

        root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        return root1 > root2 ? "Количество решений: 2. Корни: " + root2 + ";" + root1 :
                "Количество решений: 2. Корни: " + root1 + ";" + root2;
    }
}
