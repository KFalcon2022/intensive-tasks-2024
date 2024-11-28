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
        double a = -6;
        double b = 8;
        double c = 5;


        System.out.println(getAreaByHeron(a, b, c));

        double[] heightsOfTriangle = getHeights(a, b, c);
        System.out.println(Arrays.toString(heightsOfTriangle));

        double[] medianOfTriangle = getMedians(a, b, c);
        System.out.println(Arrays.toString(medianOfTriangle));

        double[] toBisect = getBisectors(a, b, c);
        System.out.println(Arrays.toString(toBisect));

        double[] toCalculateTheAngles = getAngles(a, b, c);
        System.out.println(Arrays.toString(toCalculateTheAngles));

        System.out.println(getInscribedCircleRadius(a, b, c));

        System.out.println(getCircumradius(a, b, c));
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
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double p = (a + b + c) / 2;

        return Math.sqrt((p * (p - a) * (p - b) * (p - c)));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[]{};
        }
        double p = (a + b + c) / 2;
        double s = Math.sqrt((p * (p - a) * (p - b) * (p - c)));

        double h0 = (2 * s) / a;
        double h1 = (2 * s) / b;
        double h2 = (2 * s) / c;

        double[] heightsOfTriangle = new double[]{h0, h1, h2};
        if (h0 > h1 && h1 > h2) {
            heightsOfTriangle[0] = h2;
            heightsOfTriangle[1] = h1;
            heightsOfTriangle[2] = h0;
        }
        if (h0 > h2 && h2 > h1) {
            heightsOfTriangle[0] = h1;
            heightsOfTriangle[1] = h2;
            heightsOfTriangle[2] = h0;
        }
        if (h1 > h0 && h0 > h2) {
            heightsOfTriangle[0] = h2;
            heightsOfTriangle[1] = h0;
            heightsOfTriangle[2] = h1;
        }
        if (h1 > h2 && h2 > h0) {
            heightsOfTriangle[0] = h0;
            heightsOfTriangle[1] = h2;
            heightsOfTriangle[2] = h1;
        }
        if (h2 > h0 && h0 > h1) {
            heightsOfTriangle[0] = h1;
            heightsOfTriangle[1] = h0;
            heightsOfTriangle[2] = h2;
        }
        if (h2 > h1 && h1 > h0) {
            heightsOfTriangle[0] = h0;
            heightsOfTriangle[1] = h1;
            heightsOfTriangle[2] = h1;
        }
        return heightsOfTriangle;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[]{};
        }
        double medianA = 0.5 * (Math.sqrt((2 * Math.pow(b, 2)) + (2 * Math.pow(c, 2)) - Math.pow(a, 2)));
        double medianB = 0.5 * (Math.sqrt((2 * Math.pow(a, 2)) + (2 * Math.pow(c, 2)) - Math.pow(b, 2)));
        double medianC = 0.5 * (Math.sqrt((2 * Math.pow(a, 2)) + (2 * Math.pow(b, 2)) - Math.pow(c, 2)));

        double[] medianOfTriangle = new double[]{medianA, medianB, medianC};
        if (medianA > medianB && medianB > medianC) {
            medianOfTriangle[0] = medianC;
            medianOfTriangle[1] = medianB;
            medianOfTriangle[2] = medianA;
        }
        if (medianA > medianC && medianC > medianB) {
            medianOfTriangle[0] = medianB;
            medianOfTriangle[1] = medianC;
            medianOfTriangle[2] = medianA;
        }
        if (medianB > medianC && medianC > medianA) {
            medianOfTriangle[0] = medianA;
            medianOfTriangle[1] = medianC;
            medianOfTriangle[2] = medianB;
        }
        if (medianB > medianA && medianA > medianC) {
            medianOfTriangle[0] = medianC;
            medianOfTriangle[1] = medianA;
            medianOfTriangle[2] = medianB;
        }
        if (medianC > medianA && medianA > medianB) {
            medianOfTriangle[0] = medianB;
            medianOfTriangle[1] = medianA;
            medianOfTriangle[2] = medianC;
        }
        if (medianC > medianB && medianB > medianA) {
            medianOfTriangle[0] = medianA;
            medianOfTriangle[1] = medianB;
            medianOfTriangle[2] = medianC;
        }
        return medianOfTriangle;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[]{};
        }
        double cosA = ((b * b) + (c * c) - (a * a)) / (2 * b * c);
        double cosB = ((a * a) + (c * c) - (b * b)) / (2 * a * c);
        double cosC = ((a * a) + (b * b) - (c * c)) / (2 * a * b);

        double cosADividedBy2 = Math.sqrt((1 + cosA) / 2);
        double cosBDividedBy2 = Math.sqrt((1 + cosB) / 2);
        double cosCDividedBy2 = Math.sqrt((1 + cosC) / 2);

        if ((1 + cosA < 0) || (1 + cosB < 0) || (1 + cosC < 0)) {
            return new double[]{};
        }
        double da = ((2 * b * c) / (b + c)) * cosADividedBy2;
        double db = ((2 * a * c) / (a + c)) * cosBDividedBy2;
        double dc = ((2 * a * b) / (a + b)) * cosCDividedBy2;

        double[] toBisect = new double[]{da, db, dc};
        if (da > db && db > dc) {
            toBisect[0] = dc;
            toBisect[1] = db;
            toBisect[2] = da;
        }
        if (da > dc && dc > db) {
            toBisect[0] = db;
            toBisect[1] = dc;
            toBisect[2] = da;
        }
        if (db > da && da > dc) {
            toBisect[0] = dc;
            toBisect[1] = da;
            toBisect[2] = db;
        }
        if (db > dc && dc > da) {
            toBisect[0] = da;
            toBisect[1] = dc;
            toBisect[2] = db;
        }
        if (dc > da && da > db) {
            toBisect[0] = db;
            toBisect[1] = da;
            toBisect[2] = dc;
        }
        if (dc > db && db > da) {
            toBisect[0] = da;
            toBisect[1] = db;
            toBisect[2] = dc;
        }
        return toBisect;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return new double[]{};
        }
        double cosA = ((b * b) + (c * c) - (a * a)) / (2 * b * c);
        double cosB = ((a * a) + (c * c) - (b * b)) / (2 * a * c);
        double cosC = ((a * a) + (b * b) - (c * c)) / (2 * a * b);

        double angleA = Math.acos(cosA);
        double angleB = Math.acos(cosB);
        double angleC = Math.acos(cosC);

        double angleAToDegree = Math.toDegrees(angleA);
        double angleBToDegree = Math.toDegrees(angleB);
        double angleCToDegree = Math.toDegrees(angleC);

        double[] toCalculateTheAngles = new double[]{angleAToDegree, angleBToDegree, angleCToDegree};

        if (angleA > angleB && angleB > angleC) {
            toCalculateTheAngles[0] = angleCToDegree;
            toCalculateTheAngles[1] = angleBToDegree;
            toCalculateTheAngles[2] = angleAToDegree;
        }
        if (angleA > angleC && angleC > angleB) {
            toCalculateTheAngles[0] = angleBToDegree;
            toCalculateTheAngles[1] = angleCToDegree;
            toCalculateTheAngles[2] = angleAToDegree;
        }
        if (angleB > angleA && angleA > angleC) {
            toCalculateTheAngles[0] = angleCToDegree;
            toCalculateTheAngles[1] = angleAToDegree;
            toCalculateTheAngles[2] = angleBToDegree;
        }
        if (angleB > angleC && angleC > angleA) {
            toCalculateTheAngles[0] = angleAToDegree;
            toCalculateTheAngles[1] = angleCToDegree;
            toCalculateTheAngles[2] = angleBToDegree;
        }
        if (angleC > angleB && angleB > angleA) {
            toCalculateTheAngles[0] = angleAToDegree;
            toCalculateTheAngles[1] = angleBToDegree;
            toCalculateTheAngles[2] = angleCToDegree;
        }
        if (angleC > angleA && angleA > angleB) {
            toCalculateTheAngles[0] = angleBToDegree;
            toCalculateTheAngles[1] = angleAToDegree;
            toCalculateTheAngles[2] = angleCToDegree;
        }
        return toCalculateTheAngles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double p = (a + b + c) / 2;

        return getAreaByHeron(a, b, c) / p;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */

    static double getCircumradius(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        double p = (a + b + c) / 2;

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
