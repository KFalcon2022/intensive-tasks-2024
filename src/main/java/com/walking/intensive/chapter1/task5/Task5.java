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
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
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
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double s = (a + b + c) / 2; // Полупериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        //        Место для вашего кода
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }
        double area = getAreaByHeron(a, b, c);
        double hA = 2 * area / a;
        double hB = 2 * area / b;
        double hC = 2 * area / c;

        return new double[]{hA, hB, hC};
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        //        Место для вашего кода
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }
        double mA = Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2;
        double mB = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
        double mC = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;

        return new double[]{mA, mB, mC};
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        //        Место для вашего кода
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }
        double p = (a + b + c) / 2; // Полупериметр
        double lA = 2 * Math.sqrt(b * c * p * (p - a)) / (b + c);
        double lB = 2 * Math.sqrt(a * c * p * (p - b)) / (a + c);
        double lC = 2 * Math.sqrt(a * b * p * (p - c)) / (a + b);

        return new double[]{lA, lB, lC};
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        //        Место для вашего кода
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }
        double alpha = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        double beta = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double gamma = Math.PI - alpha - beta; // Третий угол

        return new double[]{Math.toDegrees(alpha), Math.toDegrees(beta), Math.toDegrees(gamma)};
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        //        Место для вашего кода
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double area = getAreaByHeron(a, b, c);
        double p = (a + b + c) / 2;
        return area / p;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        //        Место для вашего кода
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
        //        Место для вашего кода
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double gamma = Math.acos((a * a + b * b - c * c) / (2 * a * b));
        double sinGamma = Math.sqrt(1 - Math.pow(Math.cos(gamma), 2));
        return 0.5 * a * b * sinGamma;
    }
}
