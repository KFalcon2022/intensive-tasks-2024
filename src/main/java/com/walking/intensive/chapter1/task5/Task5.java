package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

import static java.lang.Math.sqrt;

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
        double a = 12;
        double b = 1;
        double c = 4;
        System.out.println(getAreaByHeron(a, b, c));
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

    static double checkData(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a + b < c || b + c < a || a + c < b) {
            return -1.0;
        }

        return 0;
    }

    static double getAreaByHeron(double a, double b, double c) {
        if (checkData(a, b, c) == -1.0) {
            return -1.0;
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
        if (checkData(a, b, c) == -1.0) {
            return new double[0];
        }

        double s = getAreaByHeron(a, b, c);
        double h1 = 2 * s / a;
        double h2 = 2 * s / b;
        double h3 = 2 * s / c;
        double[] heights = new double[]{h1,h2,h3};
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
        if (checkData(a, b, c) == -1.0) {
            return new double[0];
        }

        double m1 = sqrt(2 * (b * b + c * c) - a * a) / 2;
        double m2 = sqrt(2 * (a * a + c * c) - b * b) / 2;
        double m3 = sqrt(2 * (a * a + b * b) - c * c) / 2;
        double[] medians = new double[]{m1,m2,m3};
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
        if (checkData(a, b, c) == -1.0) {
            return new double[0];
        }

        double b1 = sqrt(b * c * (a + b + c) * (b + c - a)) / (b + c);
        double b2 = sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c);
        double b3 = sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        double[] bisectors = new double[]{b1,b2,b3};
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
        if (checkData(a, b, c) == -1.0) {
            return new double[0];
        }

        double s = getAreaByHeron(a, b, c);
        double alpha = Math.toDegrees(Math.asin(2 * s / (a * b)));
        double beta = Math.toDegrees(Math.asin(2 * s / (b * c)));
        double gamma = Math.toDegrees(Math.asin(2 * s / (a * c)));
        double[] angles = new double[]{alpha,beta,gamma};
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
        if (checkData(a, b, c) == -1.0) {
            return -1.0;
        }

        double p = (a + b + c) / 2;
        return sqrt(((p - a) * (p - b) * (p - c)) / p);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (checkData(a, b, c) == -1.0) {
            return -1.0;
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
        if (checkData(a, b, c) == -1.0) {
            return -1.0;
        }

        double cosAlpha = (b * b + c * c - a * a) / (2 * b * c); // Теорема косинусов
        double sinAlpha = sqrt(1 - cosAlpha * cosAlpha); // Основное тригонометрическое тождество
        return 0.5 * (b * c * sinAlpha);
    }
}
