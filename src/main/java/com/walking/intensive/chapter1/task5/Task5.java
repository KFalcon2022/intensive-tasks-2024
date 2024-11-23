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
        System.out.println(Arrays.toString(getBisectors(12, 13, 5)));
        System.out.println(Arrays.toString(getAngles(12, 13, 5)));
    }

    static boolean isTriangleNonExist(double a, double b, double c) {

        return !(a + b > c) || !(a + c > b) || !(b + c > a);
    }

    static double[] getEmptyArray() {

        return new double[0];
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
        if (isTriangleNonExist(a, b, c)) {
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

        if (isTriangleNonExist(a, b, c)) {
            return getEmptyArray();
        }

        double area = getAreaByHeron(a, b, c);
        double[] triangleHeight = new double[] { (2 * area) / a, (2 * area) / b, (2 * area) / c };
        Arrays.sort(triangleHeight);

        return triangleHeight;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (isTriangleNonExist(a, b, c)) {
            return getEmptyArray();
        }

        double mA = Math.sqrt((2 * b * b) + (2 * c * c) - (a * a)) / 2;
        double mB = Math.sqrt((2 * a * a) + (2 * c * c) - (b * b)) / 2;
        double mC = Math.sqrt((2 * a * a) + (2 * b * b) - (c * c)) / 2;

        double[] triangleMedians = new double[] { mA, mB, mC };
        Arrays.sort(triangleMedians);

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

        if (isTriangleNonExist(a, b, c)) {
            return getEmptyArray();
        }

        double bA = Math.sqrt((b * c) * (1 - ((a * a) / ((b + c) * (b + c)))));
        double bB = Math.sqrt((a * c) * (1 - ((b * b) / ((a + c) * (a + c)))));
        double bC = Math.sqrt((a * b) * (1 - ((c * c) / ((a + b) * (a + b)))));

        double[] bisectorsLength = new double[] { bA, bB, bC };
        Arrays.sort(bisectorsLength);

        return bisectorsLength;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (isTriangleNonExist(a, b, c)) {
            return getEmptyArray();
        }

        double angleA = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        double angleB = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double angleC = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));

        double[] angles = new double[] { angleA, angleB, angleC};
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

        if (isTriangleNonExist(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / ((a + b + c) / 2);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (isTriangleNonExist(a, b, c)) {
            return -1;
        }

        return  (a * b * c ) / (4 * getAreaByHeron(a, b, c));
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

        return 0; // Заглушка. При реализации - удалить
    }
}
