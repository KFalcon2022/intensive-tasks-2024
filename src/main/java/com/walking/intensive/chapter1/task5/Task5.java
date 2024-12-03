package com.walking.intensive.chapter1.task5;

import java.lang.reflect.Array;
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
        //System.out.println(getAreaByHeron(3,4,5));
        //System.out.println(getHeights(3,4,5));
    }

    static boolean isCheck(double a, double b, double c) {
        boolean result = true;
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            result = false;
        }
        /*if (a > 0 && b > 0 && c > 0) {
            result = true;
        }*/
        return result;
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
        double result, p;
        if (isCheck(a, b, c)) {
            p = (a + b + c) / 2;
            double area = p * (p - a) * (p - b) * (p - c);
            result = Math.pow(area, 0.5);
            return result;
        }
        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (isCheck(a, b, c)) {
            double area = getAreaByHeron(a, b, c);
            double heightA = 2 * area / a;
            double heightB = 2 * area / b;
            double heightC = 2 * area / c;
            double[] heights = {heightA, heightB, heightC};
            Arrays.sort(heights);
            return heights;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (isCheck(a, b, c)) {
            double medianA = 0.5 * Math.pow((2 * c * c + 2 * b * b - a * a), 0.5);
            double medianB = 0.5 * Math.pow((2 * a * a + 2 * c * c - b * b), 0.5);
            double medianC = 0.5 * Math.pow((2 * a * a + 2 * b * b - c * c), 0.5);
            double[] medians = {medianA, medianB, medianC};
            Arrays.sort(medians);
            return medians;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (isCheck(a, b, c)) {
            double bisA = Math.pow(c * b * (a + b + c) * (c + b - a), 0.5) / (c + b);
            double bisB = Math.pow(a * c * (a + b + c) * (a + c - b), 0.5) / (a + c);
            double bisC = Math.pow(a * b * (a + b + c) * (a + b - c), 0.5) / (a + b);
            double[] bis = {bisA, bisB, bisC};
            Arrays.sort(bis);
            return bis;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (isCheck(a, b, c)) {
            double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            double angleC = Math.acos((b * b + a * a - c * c) / (2 * b * a));
            angleA = Math.toDegrees(angleA);
            angleB = Math.toDegrees(angleB);
            angleC = Math.toDegrees(angleC);
            double[] angles = {angleA, angleB, angleC};
            Arrays.sort(angles);
            return angles;
        }
        return new double[0];
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

        return 0; // Заглушка. При реализации - удалить
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

        return 0; // Заглушка. При реализации - удалить
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
