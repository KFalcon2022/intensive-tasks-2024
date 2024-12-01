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

        System.out.println(getAreaByHeron(12, 13, 5));
        System.out.println(Arrays.toString(getMedians(12, 13, 5)));
        System.out.println(Arrays.toString(getBisectors(12, 13, 5)));
        System.out.println(Arrays.toString(getAngles(12, 13, 5)));
        System.out.println(getAreaAdvanced(12, 13, 5));

    }

    static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b) > c && (b + c) > a && (a + c) > b;
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

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    static double getHeight(double area, double side) {
        return 2 * area / side;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        double area = getAreaByHeron(a, b, c);
        double[] heights = new double[3];
        double[] sides = {a, b, c};

        for (int i = 0; i < 3; i++) {
            heights[i] = getHeight(area, sides[i]);
        }

        Arrays.sort(heights);

        return heights;
    }

    static double getMedian(double a, double b, double c) {
        return Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        double[] medians = new double[3];

        medians[0] = getMedian(a, b, c);
        medians[1] = getMedian(a, c, b);
        medians[2] = getMedian(c, b, a);

        Arrays.sort(medians);

        return medians;
    }

    static double getBisector(double a, double b, double c) {
        return (1 / (a + b)) * Math.sqrt(a * b * ((a + b) * (a + b) - c * c));
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        double[] bisectors = new double[3];

        bisectors[0] = getBisector(a, b, c);
        bisectors[1] = getBisector(a, c, b);
        bisectors[2] = getBisector(c, b, a);

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

        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        double[] angles = new double[3];
        double[] sides = {a, b, c};
        //double[] otherSides = {b, c, a};
        double area = getAreaByHeron(a, b, c);

        for (int i = 0; i < 3; i++) {
            angles[i] = Math.toDegrees(Math.asin(getHeight(area, sides[(i + 1) % 3]) / sides[i]));
        }

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

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;

        return Math.sqrt((p - a) * (p - b) * (p - c) / p);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double area = getAreaByHeron(a, b, c);
        double sinAlpha = getHeight(area, c) / b;

        return a / (2 * sinAlpha);
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

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double cosAlpha = (b * b + c * c - a * a) / (2 * b * c);
        double sinAlpha = Math.sqrt(1 - cosAlpha * cosAlpha);

        return b * c * sinAlpha / 2;
    }
}
