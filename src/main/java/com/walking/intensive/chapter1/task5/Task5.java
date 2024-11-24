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

        if (!validateTriangle(a, b, c)) {
            return -1;
        }
        double p = calculateSemiPerimeter(a, b, c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    static double calculateSemiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static boolean validateTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if (!validateTriangle(a, b, c)) {
            return new double[0];
        }

        double p = calculateSemiPerimeter(a, b, c);
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double[] result = new double[]{a, b, c};
        for (int i = 0; i < result.length; i++) {
            result[i] = 2 * S / result[i];
        }
        Arrays.sort(result);
        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (!validateTriangle(a, b, c)) {
            return new double[0];
        }

        double[] result = new double[3];
        result[0] = calculateMedian(a, b, c);
        result[1] = calculateMedian(a, c, b);
        result[2] = calculateMedian(b, c, a);
        Arrays.sort(result);
        return result;
    }

    static double calculateMedian(double a, double b, double c) {

        return (Math.sqrt(2 * a * a + 2 * b * b - c * c)) / 2;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (!validateTriangle(a, b, c)) {
            return new double[0];
        }

        double[] result = new double[3];
        result[0] = calculateBisector(a, b, c);
        result[1] = calculateBisector(a, c, b);
        result[2] = calculateBisector(b, c, a);
        Arrays.sort(result);
        return result;
    }

    static double calculateBisector(double a, double b, double c) {

        return (Math.sqrt(a * b * (a + b + c) * (a + b - c))) / (a + b);
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (!validateTriangle(a, b, c)) {
            return new double[0];
        }
        double[] result = new double[3];
        result[0] = calculateAngle(a, b, c);
        result[1] = calculateAngle(a, c, b);
        result[2] = calculateAngle(b, c, a);
        Arrays.sort(result);
        return result;
    }

    static double calculateAngle(double a, double b, double c) {

        return Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (!validateTriangle(a, b, c)) {
            return -1;
        }

        double p = calculateSemiPerimeter(a, b, c);
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

        if (!validateTriangle(a, b, c)) {
            return -1;
        }

        double p = calculateSemiPerimeter(a, b, c);
        return (a * b * c) / (4 * Math.sqrt(p * (p - a) * (p - b) * (p - c)));
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

        if (!validateTriangle(a, b, c)) {
            return -1;
        }

        double cos = (b * b + c * c - a * a) / (2 * b * c);
        double sin = Math.sqrt(1 - cos * cos);
        return 0.5 * b * c * sin;
    }
}
