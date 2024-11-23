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

    static boolean ifTriangleExist(double a, double b, double c) {
        return  ((a + b) > c && (a + c) > b && (b + c) > a);
    }

    static double getTrianglePerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getTriangleSquare(double a, double b, double c) {
        double perimeter = getTrianglePerimeter(a, b, c);
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
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
        if (!ifTriangleExist(a, b, c)) {
            return -1;
        }
        {
            return getTriangleSquare(a, b, c);
        }
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double[] heights = new double[3];
        if (!ifTriangleExist(a, b, c)) {
            return new double[]{};
        }
        {
            double square = getTriangleSquare(a, b, c);
            double heightA = (2 * square) / a;
            double heightB = (2 * square) / b;
            double heightC = (2 * square) / c;

            heights[0] = heightA;
            heights[1] = heightB;
            heights[2] = heightC;
            Arrays.sort(heights);
            return heights;
        }
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] medians = new double[3];
        if (!ifTriangleExist(a, b, c)) {
            return new double[]{};
        }
        {
            double medianA = 0.5 * (Math.sqrt((2 * b * b) + (2 * c * c) - (a * a)));
            double medianB = 0.5 * (Math.sqrt((2 * a * a) + (2 * c * c) - (b * b)));
            double medianC = 0.5 * (Math.sqrt((2 * a * a) + (2 * b * b) - (c * c)));

            medians[0] = medianA;
            medians[1] = medianB;
            medians[2] = medianC;
            Arrays.sort(medians);
            return medians;
        }
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] bisectors = new double[3];
        if (!ifTriangleExist(a, b, c)) {
            return new double[]{};
        }
        {
            double bisectorA = (Math.sqrt((b * c) * (b + c + a) * (b + c - a))) / (b + c);
            double bisectorB = (Math.sqrt((a * c) * (a + c + b) * (a + c - b))) / (a + c);
            double bisectorC = (Math.sqrt((a * b) * (a + b + c) * (a + b - c))) / (a + b);

            bisectors[0] = bisectorA;
            bisectors[1] = bisectorB;
            bisectors[2] = bisectorC;
            Arrays.sort(bisectors);
            return bisectors;
        }
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] angles = new double[3];
        if (!ifTriangleExist(a, b, c)) {
            return new double[]{};
        }
        {
            double cosA = ((b * b) + (c * c) - (a * a)) / (2 * b * c);
            double cosB = ((a * a) + (c * c) - (b * b)) / (2 * a * c);
            double cosG = ((a * a) + (b * b) - (c * c)) / (2 * a * b);

            angles[0] = Math.toDegrees(Math.acos(cosA));
            angles[1] = Math.toDegrees(Math.acos(cosB));
            angles[2] = Math.toDegrees(Math.acos(cosG));
            Arrays.sort(angles);
            return angles;
        }
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!ifTriangleExist(a, b, c)) {
            return -1;
        }
        {
            double perimeter = getTrianglePerimeter(a, b, c);
            double square = getTriangleSquare(a, b, c);
            double rIntRadius = square / perimeter;
            return rIntRadius;
        }
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!ifTriangleExist(a, b, c)) {
            return -1;
        }
        {
            double square = getTriangleSquare(a, b, c);
            double rOutRadius = (a * b * c) / (4 * square);
            return rOutRadius;
        }
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
