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

        double a = 3;
        double b = 4;
        double c = 5;

        System.out.println(getAreaByHeron(a, b, c));
        System.out.println(Arrays.toString(getHeights(a, b, c)));
        System.out.println(Arrays.toString(getMedians(a, b, c)));
        System.out.println(Arrays.toString(getBisectors(a, b, c)));
        System.out.println(Arrays.toString(getAngles(a, b, c)));
        System.out.println(getInscribedCircleRadius(a, b, c));
        System.out.println(getCircumradius(a, b, c));
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

        if (isParametersValid(a, b, c)) {
            return -1;
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);

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

        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double[] heights = new double[3];
        heights[0] = 2 * getAreaByHeron(a, b, c) / a;
        heights[1] = 2 * getAreaByHeron(a, b, c) / b;
        heights[2] = 2 * getAreaByHeron(a, b, c) / c;
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

        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double[] medians = new double[3];
        medians[0] = Math.sqrt((2 * b * b) + (2 * c * c) - (a * a)) / 2;
        medians[1] = Math.sqrt((2 * a * a) + (2 * c * c) - (b * b)) / 2;
        medians[2] = Math.sqrt((2 * a * a) + (2 * b * b) - (c * c)) / 2;
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

        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);

        double[] bisectors = new double[3];
        bisectors[0] = 2 * Math.sqrt(halfPerimeter * (halfPerimeter - a) * b * c) / (b + c);
        bisectors[1] = 2 * Math.sqrt(halfPerimeter * (halfPerimeter - b) * a * c) / (a + c);
        bisectors[2] = 2 * Math.sqrt(halfPerimeter * (halfPerimeter - c) * a * b) / (a + b);
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

        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double[] angles = new double[3];
        angles[0] = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        angles[1] = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
        angles[2] = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * c * b)));
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

        if (isParametersValid(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / getHalfPerimeter(a, b, c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (isParametersValid(a, b, c)) {
            return -1;
        }

        return a * b * c / (4 * getAreaByHeron(a, b, c));
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

    static boolean isParametersValid(double a, double b, double c) {
        double halfPerimeter = getHalfPerimeter(a, b, c);

        return halfPerimeter <= a || halfPerimeter <= b || halfPerimeter <= c;
    }

    static double getHalfPerimeter(double a, double b, double c) {

        return (a + b + c) / 2;
    }
}
