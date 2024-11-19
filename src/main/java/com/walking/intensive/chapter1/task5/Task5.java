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

        if (!(isValidParams(a, b, c))) {
            return -1;
        }

        double halfPerimeter = (a + b + c) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        double twoTotalAreas = getAreaByHeron(a, b, c) * 2;

        if (twoTotalAreas < 0) {
            return new double[0];
        }

        return getSortedList(twoTotalAreas / a, twoTotalAreas / b, twoTotalAreas / c);
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (!(isValidParams(a, b, c))) {
            return new double[0];
        }

        double medianA = (Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2))) / 2;
        double medianB = (Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2))) / 2;
        double medianC = (Math.sqrt(2 * Math.pow(c, 2) + 2 * Math.pow(b, 2) - Math.pow(a, 2))) / 2;

        return getSortedList(medianA, medianB, medianC);
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (!(isValidParams(a, b, c))) {
            return new double[0];
        }

        double perimeter = a + b + c;

        double bisectorA = Math.sqrt(b * c * perimeter * (b + c - a)) / (b + c);
        double bisectorB = Math.sqrt(a * c * perimeter * (a + c - b)) / (a + c);
        double bisectorC = Math.sqrt(a * b * perimeter * (a + b - c)) / (a + b);

        return getSortedList(bisectorA, bisectorB, bisectorC);
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (!(isValidParams(a, b, c))) {
            return new double[0];
        }

        double powA = Math.pow(a, 2);
        double powB = Math.pow(b, 2);
        double powC = Math.pow(c, 2);

        double cosA = (powB + powC - powA) / (2 * b * c);
        double cosB = (powA + powC - powB) / (2 * a * c);

        double angleA = Math.toDegrees(Math.acos(cosA));
        double angleB = Math.toDegrees(Math.acos(cosB));
        double angleC = 180 - angleA - angleB;

        return getSortedList(angleA, angleB, angleC);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (!(isValidParams(a, b, c))) {
            return -1;
        }

        double twoTotalAreas = getAreaByHeron(a, b, c) * 2;

        return twoTotalAreas / (a + b + c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (!(isValidParams(a, b, c))) {
            return -1;
        }

        double fourTotalAreas = getAreaByHeron(a, b, c) * 4;

        return a * b * c / fourTotalAreas;
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

        if (!(isValidParams(a, b, c))) {
            return -1;
        }

        double cosA = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        double sinA = Math.abs(Math.sqrt(1 - Math.pow(cosA, 2)));

        return (c * b * sinA) / 2;
    }

    static boolean isValidParams(double a, double b, double c) {

        return (a > 0 && b > 0 && c > 0) && ((a + b > c) && (a + c > b) && (b + c > a));
    }

    static double[] getSortedList(double a, double b, double c) {

        double[] result = new double[] {a, b, c};

        Arrays.sort(result);

        return result;
    }
}
