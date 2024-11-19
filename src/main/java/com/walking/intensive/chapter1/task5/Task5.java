package com.walking.intensive.chapter1.task5;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        getAreaAdvanced(12, 13, 5);
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
        if (validTriangle(a, b, c)) {
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
        double s = getAreaByHeron(a, b, c);
        if (s == -1) {
            return new double[0];
        }
        double h1 = 2 * s / a;
        double h2 = 2 * s / b;
        double h3 = 2 * s / c;
        double[] heights = {h1, h2, h3};
        Arrays.sort(heights);
        return heights;
    }

//    private static double getRoundedNumber(double number) {
//        BigDecimal bd = new BigDecimal(number);
//        return bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
//    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (validTriangle(a, b, c)) {
            return new double[0];
        }
        double h1 = Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) / 2;
        double h2 = Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) / 2;
        double h3 = Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2)) / 2;
        double[] medians = {h1, h2, h3};
        Arrays.sort(medians);
        return medians;
    }

    private static boolean validTriangle(double a, double b, double c) {
        return (a <= 0 || b <= 0 || c <= 0) ||
                (a + b <= c || a + c <= b || b + c <= a);
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (validTriangle(a, b, c)) {
            return new double[0];
        }
        double l1 = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        double l2 = Math.sqrt(a * c * (a + c + b) * (a + c - b)) / (a + c);
        double l3 = Math.sqrt(c * b * (c + b + a) * (c + b - a)) / (c + b);
        double[] bisectors = {l1, l2, l3};
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
        if (validTriangle(a, b, c)) {
            return new double[0];
        }
        double alpha = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        double beta = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double gamma = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
        double[] angles = {alpha, beta, gamma};
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
        if (validTriangle(a, b, c)) {
            return -1;
        }
        double p = (a + b + c) / 2;
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
        if (validTriangle(a, b, c)) {
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
        if (validTriangle(a, b, c)) {
            return -1;
        }

        double beta = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double betaInRadians = beta * Math.PI / 180;
        return (a * c * Math.sin(betaInRadians)) / 2;
    }
}
