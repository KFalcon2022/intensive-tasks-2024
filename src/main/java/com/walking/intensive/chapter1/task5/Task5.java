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
//        Для собственных проверок можете делать любые изменения в этом методе
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
        if (isNotTriangle(a, b, c)) {
            return -1;
        }

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private static boolean isNotTriangle(double a, double b, double c) {
        return a <= 0 || b <= 0 || c <= 0
                || a + b <= c || a + c <= b || b + c <= a;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (isNotTriangle(a, b, c)) {
            return new double[]{};
        }

        double area = getAreaByHeron(a, b, c);
        double heightA = (2 * area) / a;
        double heightB = (2 * area) / b;
        double heightC = (2 * area) / c;

        double[] heights = new double[]{heightA, heightB, heightC};
        Arrays.sort(heights);

        return heights;
    }


    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (isNotTriangle(a, b, c)) {
            return new double[]{};
        }

        double medianA = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
        double medianB = 0.5 * Math.sqrt(2 * a * a + 2 * c * c - b * b);
        double medianC = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);

        double[] medians = {medianA, medianB, medianC};
        Arrays.sort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (isNotTriangle(a, b, c)) {
            return new double[]{};
        }

        double bisectorA = Math.sqrt(b * c * (1 - (Math.pow(a, 2) / ((b + c) * (b + c)))));
        double bisectorB = Math.sqrt(a * c * (1 - (Math.pow(b, 2) / ((a + c) * (a + c)))));
        double bisectorC = Math.sqrt(a * b * (1 - (Math.pow(c, 2) / ((a + b) * (a + b)))));

        double[] bisectors = {bisectorA, bisectorB, bisectorC};
        Arrays.sort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (isNotTriangle(a, b, c)) {
            return new double[]{};
        }

        double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double angleC = Math.PI - angleA - angleB;

        double[] angles = {Math.toDegrees(angleA), Math.toDegrees(angleB), Math.toDegrees(angleC)};
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isNotTriangle(a, b, c)) {
            return -1;
        }

        double area = getAreaByHeron(a, b, c);
        double p = (a + b + c) / 2;

        return area / p;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (isNotTriangle(a, b, c)) {
            return -1;
        }

        double area = getAreaByHeron(a, b, c);
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
        if (isNotTriangle(a, b, c)) {
            return -1;
        }

        double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double angleC = Math.PI - angleA - angleB;

        return 0.5 * a * b * Math.sin(angleC);
    }
}
