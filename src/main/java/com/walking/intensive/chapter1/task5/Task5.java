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

        if (isTriangle(a, b, c)) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if (isTriangle(a, b, c)) {
            double S = getAreaByHeron(a, b, c);
            double[] hights = {(2 * S / a), (2 * S / b), (2 * S / c)};
            Arrays.sort(hights);
            return hights;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (isTriangle(a, b, c)) {
            double[] madian = {getMedian(a, b, c), getMedian(a, c, b), getMedian(c, b, a)};
            Arrays.sort(madian);
            return madian;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (isTriangle(a, b, c)) {
            double[] bisector = {getBisector(a, b, c), getBisector(a, c, b), getBisector(c, b, a)};
            Arrays.sort(bisector);
            return bisector;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (isTriangle(a, b, c)) {
            double S = getAreaByHeron(a, b, c);
            double[] angles = {getAngle(S, a, b), getAngle(S, c, a), getAngle(S, b, c)};
            Arrays.sort(angles);
            return angles;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (isTriangle(a, b, c)) {
            return 2 * getAreaByHeron(a, b, c) / (a + b + c);
        }
        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (isTriangle(a, b, c)) {
            return (a * b * c) / (4 * getAreaByHeron(a, b, c));
        }
        return -1;
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
        if (isTriangle(a, b, c)) {
            double cosa = (c * c + b * b - a * a) / (2 * c * b);
            double sina = Math.sqrt(1 - Math.pow(cosa, 2));
            return 0.5 * sina * b * c;
        }
        return -1;
    }

    // методы для расчтета отдельных показателей
    static double getMedian(double a, double b, double c) {
        return 0.5 * Math.sqrt(2 * (a * a + b * b) - c * c);
    }

    static double getBisector(double a, double b, double c) {
        return Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
    }

    static double getAngle(double S, double a, double b) {
        return Math.asin((2 * S / a) / b) * 180 / Math.PI;
    }

    // методы для проверки существования треугольника
    static boolean isTriangle(double a, double b, double c) {

        boolean conditionPositive = a > 0 & b > 0 & c > 0;
        boolean conditionLength = a + b > c & a + c > b & b + c > a;
        return (conditionPositive & conditionLength);
    }
}
