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
        getAreaAdvanced(12, 13, 5);
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
        if (validateTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double s = getAreaByHeron(a, b, c);
        if (s == -1) {
            return new double[0];
        }

        double h1 = getHeight(s, a);
        double h2 = getHeight(s, b);
        double h3 = getHeight(s, c);

        double[] heights = {h1, h2, h3};
        Arrays.sort(heights);
        return heights;
    }

    private static double getHeight(double s, double side) {
        return 2 * s / side;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (validateTriangle(a, b, c)) {
            return new double[0];
        }

        double h1 = getHeight(a, b, c);
        double h2 = getHeight(b, c, a);
        double h3 = getHeight(a, c, b);

        double[] medians = {h1, h2, h3};
        Arrays.sort(medians);
        return medians;
    }

    private static double getHeight(double a, double b, double c) {
        return Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) / 2;
    }

    private static boolean validateTriangle(double a, double b, double c) {
        return a <= 0 || b <= 0 || c <= 0
                || a + b <= c || a + c <= b || b + c <= a;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (validateTriangle(a, b, c)) {
            return new double[0];
        }

        double l1 = getBisector(a, b, c);
        double l2 = getBisector(a, c, b);
        double l3 = getBisector(c, b, a);

        double[] bisectors = {l1, l2, l3};
        Arrays.sort(bisectors);
        return bisectors;
    }

    private static double getBisector(double a, double b, double c) {
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
        if (validateTriangle(a, b, c)) {
            return new double[0];
        }

        double alpha = getAngle(a, b, c);
        double beta = getAngle(b, a, c);
        double gamma = getAngle(c, a, b);

        double[] angles = {alpha, beta, gamma};
        Arrays.sort(angles);
        return angles;
    }

    private static double getAngle(double a, double b, double c) {
        return Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (validateTriangle(a, b, c)) {
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
        if (validateTriangle(a, b, c)) {
            return -1;
        }

        double s = getAreaByHeron(a, b, c);
        return (a * b * c) / (4 * s);
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
        if (validateTriangle(a, b, c)) {
            return -1;
        }

        return (a * c * Math.sin(convertedToRadians(getAngle(b,a,c)))) / 2;
    }

    private static double convertedToRadians(double angle){
        return angle * Math.PI / 180;
    }
}
