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
    static final double[] EMPTY_ARRAY = new double[0];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAngles(12, 13, 5)));
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

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double p = getSemiPerimeter(a, b, c);

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

        if (!isValidTriangle(a, b, c)) {
            return EMPTY_ARRAY;
        }

        double[] sideLengths = new double[]{a, b, c};
        double[] allHeights = new double[3];

        allHeights[0] = getHeight(a, sideLengths);
        allHeights[1] = getHeight(b, sideLengths);
        allHeights[2] = getHeight(c, sideLengths);

        return ascendingSort(allHeights);
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return EMPTY_ARRAY;
        }

        double[] allMedians = new double[3];

        allMedians[0] = getMedian(a, a, b, c);
        allMedians[1] = getMedian(b, a, b, c);
        allMedians[2] = getMedian(c, a, b, c);

        return ascendingSort(allMedians);
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return EMPTY_ARRAY;
        }

        double[] allBisectors = new double[3];

        allBisectors[0] = getBisector(a, a, b, c);
        allBisectors[1] = getBisector(b, a, b, c);
        allBisectors[2] = getBisector(c, a, b, c);

        return ascendingSort(allBisectors);
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return EMPTY_ARRAY;
        }

        double[] allAngles = new double[3];

        allAngles[0] = getAngle(a, a, b, c);
        allAngles[1] = getAngle(b, a, b, c);
        allAngles[2] = getAngle(c, a, b, c);

        return ascendingSort(allAngles);
    }

    /**
     * Реализуйте метод, который
     * будет возвращать
     * длину радиуса
     * вписанной в
     * треугольник окружности.
     *
     *
     * <p> Входные параметры -
     * длина сторон
     * треугольника .
     *
     *
     * <p> Если входные
     * данные некорректны -
     * метод должен
     * возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double area = getAreaByHeron(a, b, c);
        double semiperimeter = getSemiPerimeter(a, b, c);

        return area / semiperimeter;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double area = getAreaByHeron(a, b, c);

        return (a * b * c) / (4 * area);
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

        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double cos = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
        double sin = Math.sqrt(1 - Math.pow(cos, 2));

        return 0.5 * a * b * sin;
    }

    static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    static double getSemiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getHeight(double requiredHeight, double[] lengthSides) {
        double doubleArea = getAreaByHeron(lengthSides[0], lengthSides[1], lengthSides[2]) * 2;
        return doubleArea / requiredHeight;
    }

    static double getMedian(double requiredMedian, double a, double b, double c) {
        double result = -1;

        if (requiredMedian == a) {
            result = 0.5 * Math.sqrt(2 * (Math.pow(b, 2) + Math.pow(c, 2)) - Math.pow(a, 2));
        } else if (requiredMedian == b) {
            result = 0.5 * Math.sqrt(2 * (Math.pow(c, 2) + Math.pow(a, 2)) - Math.pow(b, 2));
        } else if (requiredMedian == c) {
            result = 0.5 * Math.sqrt(2 * (Math.pow(a, 2) + Math.pow(b, 2)) - Math.pow(c, 2));
        }

        return result;
    }

    static double getBisector(double requiredBisector, double a, double b, double c) {
        double result = -1;

        if (requiredBisector == a) {
            result = Math.sqrt(b * c * (1 - (Math.pow(a, 2) / Math.pow((b + c), 2))));
        } else if (requiredBisector == b) {
            result = Math.sqrt(a * c * (1 - (Math.pow(b, 2) / Math.pow((a + c), 2))));
        } else if (requiredBisector == c) {
            result = Math.sqrt(a * b * (1 - (Math.pow(c, 2) / Math.pow((a + b), 2))));
        }

        return result;
    }

    static double getAngle(double requiredAngle, double a, double b, double c) {
        double result = -1;

        if (requiredAngle == a) {
            result = Math.toDegrees(Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)));
        } else if (requiredAngle == b) {
            result = Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)));
        } else if (requiredAngle == c) {
            result = Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
        }

        return result;
    }

    static double[] ascendingSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
