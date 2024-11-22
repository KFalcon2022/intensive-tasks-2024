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
        double a = 12, b = 13, c = 5;

        print("Треугольник - a = " + a + ", b = " + b + ", c = " + c);
        print("Площадь треугольника формулой Герона - " + getAreaByHeron(a, b, c));
        print("Высоты треугольника - " + Arrays.toString(getHeights(a, b, c)));
        print("Медианы треугольника - " + Arrays.toString(getMedians(a, b, c)));
        print("Биссектрисы треугольника - " + Arrays.toString(getBisectors(a, b, c)));
        print("Углы треугольника - " + Arrays.toString(getAngles(a, b, c)));
        print("Длина радиуса вписанной в треугольник окружности - " + getInscribedCircleRadius(a, b, c));
        print("Длина радиуса описанной вокруг треугольника окружности - " + getCircumradius(a, b, c));
        print("Площадь треугольника - " + getAreaAdvanced(a, b, c));
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
        if (isTriangle(a, b, c)) {
            return new double[0];
        }

        double s = getAreaByHeron(a, b, c);

        double[] heights = new double[3];
        heights[0] = (2.0 * s) / a;
        heights[1] = (2.0 * s) / b;
        heights[2] = (2.0 * s) / c;

        sort(heights);

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
        if (isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] medians = new double[3];
        medians[0] = Math.sqrt((b * b * 2) + (c * c * 2) - (a * a)) / 2;
        medians[1] = Math.sqrt((a * a * 2) + (c * c * 2) - (b * b)) / 2;
        medians[2] = Math.sqrt((b * b * 2) + (a * a * 2) - (c * c)) / 2;

        sort(medians);

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
        if (isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] bisectors = new double[3];
        bisectors[0] = Math.sqrt(b * c * (b + c + a) * (b + c - a)) / (b + c);
        bisectors[1] = Math.sqrt(a * c * (a + c + b) * (a + c - b)) / (a + c);
        bisectors[2] = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);

        sort(bisectors);

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
        if (isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] angles = new double[3];
        angles[0] = Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2 * b * c)));
        angles[1] = Math.toDegrees(Math.acos(((a * a) + (c * c) - (b * b)) / (2 * a * c)));
        angles[2] = Math.toDegrees(Math.acos(((a * a) + (b * b) - (c * c)) / (2 * a * b)));

        sort(angles);

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
        if (isTriangle(a, b, c)) {
            return -1;
        }

        double s = getAreaByHeron(a, b, c);

        return 2 * s / (a + b + c);
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
        if (isTriangle(a, b, c)) {
            return -1;
        }

        double cosinesA = ((c * c) + (b * b) - (a * a)) / (2 * c * b);
        double sinusA = Math.sqrt(1 - (cosinesA * cosinesA));

        return ((b * c * sinusA) / 2);
    }

    private static <E> void print(E e) {
        System.out.println(e);
    }

    private static void sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double min = array[i];

            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    array[j] = array[i];
                    array[i] = min;
                }
            }
        }
    }

    private static boolean isTriangle(double a, double b, double c) {
        return !(a < b + c) ||
                !(b < a + c) ||
                !(c < b + a);
    }
}
