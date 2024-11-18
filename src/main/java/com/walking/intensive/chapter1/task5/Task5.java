package com.walking.intensive.chapter1.task5;

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
        System.out.println(getAreaAdvanced(3, 4, 5));
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
        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        double semiperimeter = (a + b + c) / 2;

        return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double area = getAreaByHeron(a, b, c);
        double[] result = new double[3];
        double maxSide = Math.max(Math.max(a, b), c);
        double minSide = Math.min(Math.min(a, b), c);
        double mediumSide = a + b + c - maxSide - minSide;

        result[0] = 2 * area / maxSide;
        result[1] = 2 * area / mediumSide;
        result[2] = 2 * area / minSide;

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double m1 = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
        double m2 = Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2;
        double m3 = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;

        double[] result = new double[3];
        result[0] = Math.min(Math.min(m1, m2), m3);
        result[2] = Math.max(Math.max(m1, m2), m3);
        result[1] = m1 + m2 + m3 - result[0] - result[2];

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double b1 = Math.sqrt(b * c * (b * b + 2 * b * c + c * c - a * a)) / (b + c);
        double b2 = Math.sqrt(a * c * (a * a + 2 * a * c + c * c - b * b)) / (a + c);
        double b3 = Math.sqrt(a * b * (a * a + 2 * a * b + b * b - c * c)) / (a + b);

        double[] result = new double[3];
        result[0] = Math.min(Math.min(b1, b2), b3);
        result[2] = Math.max(Math.max(b1, b2), b3);
        result[1] = b1 + b2 + b3 - result[0] - result[2];

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double area = getAreaByHeron(a, b, c);
        double angleA = Math.asin(2 * area / b / c) * 180 / Math.PI;
        double angleB = Math.asin(2 * area / a / c) * 180 / Math.PI;
        double angleC = Math.asin(2 * area / a / b) * 180 / Math.PI;

        double[] result = new double[3];
        result[0] = Math.min(Math.min(angleA, angleB), angleC);
        result[2] = Math.max(Math.max(angleA, angleB), angleC);
        result[1] = angleA + angleB + angleC - result[0] - result[2];

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / (a + b + c) * 2;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        return a * b * c / 4 / getAreaByHeron(a, b, c);
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

        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        double cosC = (a * a + b * b - c * c) / 2 / a / b;
        double sinC = Math.sqrt(1 - cosC * cosC);

        return a * b * sinC / 2;
    }

    static boolean isInvalidTriangle(double a, double b, double c) {
        return a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a;
    }
}
