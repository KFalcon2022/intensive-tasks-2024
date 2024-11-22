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

    static double negativeResult = -1.0;

    public static void main(String[] args) {

        System.out.println(getAreaByHeron(12, 1, 4));
        System.out.println();
        System.out.println(Arrays.toString(getHeights(12, 13, 5)));
        System.out.println();
        System.out.println(Arrays.toString(getMedians(12, 13, 5)));
        System.out.println();
        System.out.println(Arrays.toString(getBisectors(12, 13, 5)));
        System.out.println();
        System.out.println(Arrays.toString(getAngles(12, 13, 5)));
        System.out.println();
        System.out.println(getInscribedCircleRadius(12, 13, 5));
        System.out.println();
        System.out.println(getCircumradius(12, 13, 5));
        System.out.println();
        System.out.println(getAreaAdvanced(12, 13, 5));
    }

    static double getHalfPerimeter(double a, double b, double c) {

        return (a + b + c) / 2;
    }

    static double[] getArrayEmpty() {

        return new double[0];
    }

    static boolean getIncorrectData(double a, double b, double c) {

        return a > b + c || b > a + c || c > a + b;
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

        if (getIncorrectData(a, b, c)) {
            return negativeResult;
        }

        return Math.sqrt(getHalfPerimeter(a, b, c) * (getHalfPerimeter(a, b, c) - a)
                * (getHalfPerimeter(a, b, c) - b) * (getHalfPerimeter(a, b, c) - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        double triangleArea = getAreaByHeron(a, b, c);

        double[] triangleHeights = new double[3];
        triangleHeights[0] = 2 * triangleArea / a;
        triangleHeights[1] = 2 * triangleArea / b;
        triangleHeights[2] = 2 * triangleArea / c;

        Arrays.sort(triangleHeights);

        if (getIncorrectData(a, b, c)) {
            return getArrayEmpty();
        }

        return triangleHeights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        double[] triangleMedians = new double[3];
        triangleMedians[0] = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);
        triangleMedians[1] = 0.5 * Math.sqrt(2 * a * a + 2 * c * c - b * b);
        triangleMedians[2] = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);

        Arrays.sort(triangleMedians);

        if (getIncorrectData(a, b, c)) {
            return getArrayEmpty();
        }

        return triangleMedians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        double[] triangleBisectors = new double[3];
        triangleBisectors[0] = 2 * Math.sqrt(a * b * getHalfPerimeter(a, b, c)
                * (getHalfPerimeter(a, b, c) - c)) / (a + b);
        triangleBisectors[1] = 2 * Math.sqrt(b * c * getHalfPerimeter(a, b, c)
                * (getHalfPerimeter(a, b, c) - a)) / (b + c);
        triangleBisectors[2] = 2 * Math.sqrt(a * c * getHalfPerimeter(a, b, c)
                * (getHalfPerimeter(a, b, c) - b)) / (a + c);

        Arrays.sort(triangleBisectors);

        if (getIncorrectData(a, b, c)) {
            return getArrayEmpty();
        }

        return triangleBisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        double[] triangleAngles = new double[3];
        triangleAngles[0] = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        triangleAngles[1] = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        triangleAngles[2] = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));

        Arrays.sort(triangleAngles);

        if (getIncorrectData(a, b, c)) {
            return getArrayEmpty();
        }

        return triangleAngles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (getIncorrectData(a, b, c)) {
            return negativeResult;
        }

        return Math.sqrt((getHalfPerimeter(a, b, c) - a) * (getHalfPerimeter(a, b, c) - b)
                * (getHalfPerimeter(a, b, c) - c) / getHalfPerimeter(a, b, c));
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (getIncorrectData(a, b, c)) {
            return negativeResult;
        }

        return (a * b * c) / (4 * Math.sqrt(getHalfPerimeter(a, b, c) * (getHalfPerimeter(a, b, c) - a)
                * (getHalfPerimeter(a, b, c) - b) * (getHalfPerimeter(a, b, c) - c)));
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

        double cosineAlpha = (b * b + c * c - a * a) / (2 * b * c);
        double sineAlpha = Math.sqrt(1 - Math.pow(cosineAlpha, 2));
        double triangleArea = 0.5 * b * c * sineAlpha;

        if (getIncorrectData(a, b, c)) {
            return negativeResult;
        }

        return triangleArea;
    }
}
