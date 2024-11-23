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
        System.out.println();

        double[] heights = getHeights(a, b, c);
        for (double height : heights) {
            System.out.println(height);
        }
        System.out.println();

        double[] medians = getMedians(a, b, c);
        for (double median : medians) {
            System.out.println(median);
        }
        System.out.println();

        double[] bisectors = getBisectors(a, b, c);
        for (double bisector : bisectors) {
            System.out.println(bisector);
        }
        System.out.println();

        double[] angles = getAngles(a, b, c);
        for (double angle : angles) {
            System.out.println(angle);
        }
        System.out.println();

        System.out.println(getInscribedCircleRadius(a, b, c));
        System.out.println();

        System.out.println(getCircumradius(a, b, c));
        System.out.println();

        System.out.println(getAreaAdvanced(a, b, c));
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
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
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
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] heights = new double[3];

        double areaByHeron = getAreaByHeron(a, b, c);

        heights[0] = 2 * areaByHeron / a;
        heights[1] = 2 * areaByHeron / b;
        heights[2] = 2 * areaByHeron / c;

        Arrays.sort(heights);

        return heights;
    }

    public static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static boolean paramsIsNegative(double a, double b, double c) {
        return a <= 0 || b <= 0 || c <= 0;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return new double[0];
        }

        double medianA = Math.sqrt((2 * b * b + 2 * c * c - a * a)) / 2;
        double medianB = Math.sqrt((2 * a * a + 2 * c * c - b * b)) / 2;
        double medianC = Math.sqrt((2 * a * a + 2 * b * b - c * c)) / 2;

        double[] medians = {medianA, medianB, medianC};

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
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return new double[0];
        }

        double bisectorA = Math.sqrt(b * c * (1 - a * a / Math.pow(b + c, 2)));
        double bisectorB = Math.sqrt(a * c * (1 - b * b / Math.pow(a + c, 2)));
        double bisectorC = Math.sqrt(a * b * (1 - c * c / Math.pow(a + b, 2)));

        double[] bisectors = {bisectorA, bisectorB, bisectorC};

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
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return new double[0];
        }

        double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c)) * 180 / Math.PI;
        double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c)) * 180 / Math.PI;
        double angleC = Math.acos((a * a + b * b - c * c) / (2 * a * b)) * 180 / Math.PI;

        double[] angles = {angleA, angleB, angleC};

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
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return -1;
        }

        double areaByHeron = getAreaByHeron(a, b, c);

        return areaByHeron / ((a + b + c) / 2);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return -1;
        }

        double areaByHeron = getAreaByHeron(a, b, c);

        return (a * b * c) / (4 * areaByHeron);
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
        if (paramsIsNegative(a, b, c) || !isTriangle(a, b, c)) {
            return -1;
        }

        double cosA = (a * a + b * b - c * c) / (2 * a * b);
        double sinA = Math.sqrt(1 - cosA * cosA);

        return 0.5 * a * b * sinA;
    }
}
