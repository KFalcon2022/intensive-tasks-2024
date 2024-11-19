package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

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
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return new double[0];
        }
        double h1 = getAreaByHeron(a, b, c) * 2 / a;
        double h2 = getAreaByHeron(a, b, c) * 2 / b;
        double h3 = getAreaByHeron(a, b, c) * 2 / c;

        double[] result = {h1, h2, h3};
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
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return new double[0];
        }

        double ma = sqrt(2 * pow(b, 2) + 2 * pow(c, 2) - pow(a, 2)) / 2;
        double mb = sqrt(2 * pow(c, 2) + 2 * pow(a, 2) - pow(b, 2)) / 2;
        double mc = sqrt(2 * pow(a, 2) + 2 * pow(b, 2) - pow(c, 2)) / 2;

        double[] result = {ma, mb, mc};
        Arrays.sort(result);

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return new double[0];
        }

        double ba = sqrt(b * c * (b + c + a) * (b + c - a)) / (b + c);
        double bb = sqrt(a * c * (a + c + b) * (a + c - b)) / (a + c);
        double bc = sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);

        double[] result = {ba, bb, bc};
        Arrays.sort(result);

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return new double[0];
        }

        double cosA = (pow(b, 2) + pow(c, 2) - pow(a, 2)) / (2 * b * c);
        double cosB = (pow(a, 2) + pow(c, 2) - pow(b, 2)) / (2 * a * c);
        double cosC = (pow(a, 2) + pow(b, 2) - pow(c, 2)) / (2 * a * b);

        double angleA = Math.toDegrees(Math.acos(cosA));
        double angleB = Math.toDegrees(Math.acos(cosB));
        double angleC = Math.toDegrees(Math.acos(cosC));

        double[] result = {angleA, angleB, angleC};
        Arrays.sort(result);

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;
        return sqrt((p - a) * (p - b) * (p - c) / p);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return -1;
        }

        return (a * b * c) / sqrt((a + b + c) * (b + c - a) * (c + a - b) * (a + b - c));
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
        //        Место для вашего кода
        if (!isTrianglePossible(a, b, c)) {
            return -1;
        }

        double cosA = (pow(b, 2) + pow(c, 2) - pow(a, 2)) / (2 * b * c);
        double sinA = sqrt(1 - pow(cosA, 2));
        return b * c / 2 * sinA;
    }

    static boolean isTrianglePossible(double a, double b, double c) {
        // проверка возможности существования треугольника
        return a + b > c && b + c > a && c + a > b;
    }
}
