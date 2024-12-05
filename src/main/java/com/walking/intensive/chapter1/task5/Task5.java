package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {

    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double semiPerimeter = (a + b + c) / 2;
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - a) *
                (semiPerimeter - b) *
                (semiPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[0];
        }
        double area = calculateSquare(a, b, c);
        double heightA = (2 * area) / a;
        double heightB = (2 * area) / b;
        double heightC = (2 * area) / c;
        double[] heights = {heightA, heightB, heightC};
        Arrays.sort(heights);
        return heights;
    }

    private static double calculateSquare(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2;

        return Math.sqrt(semiPerimeter *
                (semiPerimeter - a) *
                (semiPerimeter - b) *
                (semiPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[0];
        }
        double medianA = calculateMedians(a, b, c);
        double medianB = calculateMedians(b, c, a);
        double medianC = calculateMedians(c, a, b);
        double[] medians = {medianA, medianB, medianC};
        Arrays.sort(medians);
        return medians;
    }

    private static double calculateMedians(double a, double b, double c) {
        return Math.sqrt((2 * b * b + 2 * c * c  - a * a) / 4);
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[0];
        }
        double bisectorA = calculateBisector(a, b, c);
        double bisectorB = calculateBisector(b, c, a);
        double bisectorC = calculateBisector(c, a, b);

        // Формирование массива и его сортировка
        double[] bisectors = {bisectorA, bisectorB, bisectorC};
        Arrays.sort(bisectors);
        return bisectors;

    }

    private static double calculateBisector(double a, double b, double c) {
        return Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[0];
        }

        double angleA = calculateAngle(b, c, a);
        double angleB = calculateAngle(a, c, b);
        double angleC = calculateAngle(a, b, c);

        double[] angles = {angleA, angleB, angleC};
        Arrays.sort(angles);
        return angles;
    }

    private static double calculateAngle(double a, double b, double opposite) {
        double cosTheta = (a * a + b * b - opposite * opposite) / (2 * a * b);
        return Math.toDegrees(Math.acos(cosTheta));
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double semiPerimeter = (a + b + c) / 2;

        double area = Math.sqrt(semiPerimeter *
                (semiPerimeter - a) *
                (semiPerimeter - b) *
                (semiPerimeter - c));

        return area / semiPerimeter;

    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double semiPerimeter = (a + b + c) / 2;
        double area = Math.sqrt(semiPerimeter *
                (semiPerimeter - a) *
                (semiPerimeter - b) *
                (semiPerimeter - c));

        // Радиус описанной окружности
        return (a * b * c) / (4 * area);
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double sinA = Math.sqrt(1 - cosA * cosA);
        return 0.5 * b * c * sinA;
    }
}







