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
        double a = 5.0;
        double b = 6.0;
        double c = 7.0;

        System.out.println(getAreaByHeron(a, b, c));
        System.out.println(Arrays.toString(getHeights(a, b, c)));
        System.out.println(Arrays.toString(getMedians(a, b, c)));
        System.out.println(Arrays.toString(getBisectors(a, b, c)));
        System.out.println(Arrays.toString(getAngles(a, b, c)));
        System.out.println(getInscribedCircleRadius(a, b, c));
        System.out.println(getCircumradius(a, b, c));
        //System.out.println(conditionExistTriangle(a, b, c));
    }

    static boolean conditionExistTriangle(double a, double b, double c) {
        if ((a < 0 || b < 0 || c < 0) || (a + b < c || a + c < b || c + b < a))

            return false;
        return true;
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
    // s =(a+b+c)/2 - полупириметр;        a= s*(s-a)*(s-b)*(s-c) площадь;
    static double getAreaByHeron(double a, double b, double c) {
        //        Место для вашего кода
        if (!conditionExistTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;
        double sTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return sTriangle;


    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     * <p>
     * p =(a+b+c)/2 - полупириметр;   высота - (2/a)*Math.sqrt(p*(p-a)*(p-b)*(p-c))
     */
    static double[] getHeights(double a, double b, double c) {
        //        Место для вашего кода
        if (!conditionExistTriangle(a, b, c)) {
            return new double[0];
        }

        double s = getAreaByHeron(a, b, c);
        double h1 = (2.0 / a) * s;
        double h2 = (2.0 / b) * s;
        double h3 = (2.0 / c) * s;

        double[] heights = {h1, h2, h3};
        Arrays.sort(heights);

        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     * <p>
     * Ma=(Math.sqrt(2*b*b + 2*c*c - a*a))/2
     */
    static double[] getMedians(double a, double b, double c) {
        if (!conditionExistTriangle(a, b, c)) {
            return new double[0];
        }

        double m1 = (Math.sqrt(2 * b * b + 2 * c * c - a * a)) / 2;
        double m2 = (Math.sqrt(2 * a * a + 2 * c * c - b * b)) / 2;
        double m3 = (Math.sqrt(2 * a * a + 2 * b * b - c * c)) / 2;

        double[] medians = {m1, m2, m3};
        Arrays.sort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     * <p>
     * bis=(Math.sqrt(b*c*((b+c)*(b+c)-a*a))/(b+c) - биссектриса
     */
    static double[] getBisectors(double a, double b, double c) {
        //        Место для вашего кода
        if (!conditionExistTriangle(a, b, c)) {
            return new double[0];
        }

        double bis1 = (Math.sqrt(b * c * ((b + c) * (b + c) - a * a))) / (b + c);
        double bis2 = (Math.sqrt(a * c * ((a + c) * (a + c) - b * b))) / (a + c);
        double bis3 = (Math.sqrt(a * b * ((a + b) * (a + b) - c * c))) / (a + b);

        double[] bisectors = {bis1, bis2, bis3};
        Arrays.sort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     * <p>
     * ang=arccos((a*a+b*b-c*c)/2*a*b))
     */
    static double[] getAngles(double a, double b, double c) {
        //        Место для вашего кода
        if (!conditionExistTriangle(a, b, c)) {
            return new double[0];
        }

        double radiansAng1 = Math.acos((((b * b) + (c * c)) - (a * a)) / (2 * b * c));
        double degreesAng1 = Math.toDegrees(radiansAng1);

        double radiansAng2 = Math.acos((((a * a) + (c * c)) - (b * b)) / (2 * a * c));
        double degreesAng2 = Math.toDegrees(radiansAng2);

        double radiansAng3 = Math.acos((((a * a) + (b * b)) - (c * c)) / (2 * a * b));
        double degreesAng3 = Math.toDegrees(radiansAng3);

        double[] angles = {degreesAng1, degreesAng2, degreesAng3};
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     * <p>
     * p =(a+b+c)/2 - полупириметр;   высота - Math.sqrt((p-a)*(p-b)*(p-c))/p)
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        //        Место для вашего кода
        if (!conditionExistTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;
        double inscrRadius = Math.sqrt(((p - a) * (p - b) * (p - c)) / p);

        return inscrRadius;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     * <p>
     * r=(a*b*c)/(4*s)
     */
    static double getCircumradius(double a, double b, double c) {
        //        Место для вашего кода
        if (!conditionExistTriangle(a, b, c)) {
            return -1;
        }

        double s = getAreaByHeron(a, b, c);
        double circRadius = (a * b * c) / (4 * s);

        return circRadius;
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
