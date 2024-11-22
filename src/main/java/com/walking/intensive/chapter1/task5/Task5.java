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
    private static final int COUNT_SIDES = 3;
    public static final double[] NULL_ARRAY = new double[0];

    public static void main(String[] args) {
        double a = 12;
        double b = 13;
        double c = 5;

        System.out.println(Arrays.toString(getBisectors(a, b, c)));
        //System.out.println(getAreaByHeron(a, b, c));
    }

    private static boolean getIsNotCorrectInput(double a, double b, double c) {
        return !(a > Math.abs(b - c) && b > Math.abs(a - c) && c > Math.abs(a - b));
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

        if (getIsNotCorrectInput(a, b, c)) {
            return -1;
        }

        double halfPerimeter = 0.5 * (a + b + c);

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

        if (getIsNotCorrectInput(a, b, c)) {
            return NULL_ARRAY;
        }

        double[] sides = {a, b, c};
        double[] heights = new double[COUNT_SIDES];
        double halfPerimeter = getAreaByHeron(a, b, c);

        for (int i = 0; i < sides.length; i++) {
            heights[i] = 2 * Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c))
                    / sides[i];
        }

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

        if (getIsNotCorrectInput(a, b, c)) {
            return NULL_ARRAY;
        }

        double[] medians = new double[COUNT_SIDES];

        medians[0] = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);
        medians[1] = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
        medians[2] = 0.5 * Math.sqrt(2 * c * c + 2 * a * a - b * b);

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

        if (getIsNotCorrectInput(a, b, c)) {
            return NULL_ARRAY;
        }

        double[] bisectors = new double[COUNT_SIDES];
        bisectors[0] = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        bisectors[1] = Math.sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c);
        bisectors[2] = Math.sqrt(b * c * (a + b + c) * (b + c - a)) / (b + c);

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

        if (getIsNotCorrectInput(a, b, c)) {
            return NULL_ARRAY;
        }

        double[] angles = new double[COUNT_SIDES];
        double area = getAreaByHeron(a, b, c);
        angles[0] = Math.asin(2 * area / a / b);
        angles[1] = Math.asin(2 * area / a / c);
        angles[2] = Math.asin(2 * area / b / c);

        Arrays.sort(angles);

        return angles; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (getIsNotCorrectInput(a, b, c)) {
            return -1;
        }

        double halfPerimeter = 0.5 * (a + b + c);

        return Math.sqrt((halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c) / halfPerimeter);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (getIsNotCorrectInput(a, b, c)) {
            return -1;
        }

        double halfPerimeter = 0.5 * (a + b + c);

        return a * b * c / Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)) / 4;
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

        return a + b + c;
    }
}
