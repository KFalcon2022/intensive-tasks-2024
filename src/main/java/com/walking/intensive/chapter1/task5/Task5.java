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

    private static boolean isTriangle(double a, double b, double c) {
        return (a < b + c && b < a + c && c < b + a);
    }

    private static double getSemiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
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
        if (!isTriangle(a, b, c)) {
            return -1;
        }

        double semiPerimeter = getSemiPerimeter(a, b, c);

        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (!isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] triangleHeights = new double[3];
        double area = getAreaByHeron(a, b, c);
        triangleHeights[0] = (area * 2) / a;
        triangleHeights[1] = (area * 2) / b;
        triangleHeights[2] = (area * 2) / c;
        Arrays.sort(triangleHeights);

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
        if (!isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] medians = new double[3];
        medians[0] = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);
        medians[1] = 0.5 * Math.sqrt(2 * a * a + 2 * c * c - b * b);
        medians[2] = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
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
        if (!isTriangle(a, b, c)) {
            return new double[0];
        }

        double semiPerimeter = getSemiPerimeter(a, b, c);

        double[] bisectors = new double[3];
        bisectors[0] = (2 * (Math.sqrt(b * c * semiPerimeter * (semiPerimeter - a)) / (b + c)));
        bisectors[1] = (2 * (Math.sqrt(a * c * semiPerimeter * (semiPerimeter - b)) / (a + c)));
        bisectors[2] = (2 * (Math.sqrt(a * b * semiPerimeter * (semiPerimeter - c)) / (a + b)));
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
        if (!isTriangle(a, b, c)) {
            return new double[0];
        }

        double[] angles = new double[3];
        angles[0] = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        angles[1] = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        angles[2] = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
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
        if (!isTriangle(a, b, c)) {
            return -1;
        }

        double semiPerimeter = getSemiPerimeter(a, b, c);

        return Math.sqrt((semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c) / semiPerimeter);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isTriangle(a, b, c)) {
            return -1;
        }

        return (a * b * c) / (4 * getAreaByHeron(a, b, c));
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
