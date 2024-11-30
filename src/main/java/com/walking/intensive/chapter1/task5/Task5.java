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
        double a = 17;
        double b = 1;
        double c = 1;

        System.out.println(getAreaByHeron(a, b, c));

        double[] heightsOfTriangle = getHeights(a, b, c);
        System.out.println(Arrays.toString(heightsOfTriangle));

        double[] medianOfTriangle = getMedians(a, b, c);
        System.out.println(Arrays.toString(medianOfTriangle));

        double[] toBisect = getBisectors(a, b, c);
        System.out.println(Arrays.toString(toBisect));

        double[] angles = getAngles(a, b, c);
        System.out.println(Arrays.toString(angles));

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

    static double check(double a, double b, double c) {
        if (a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) {
            return -1;
        }
        return 0;
    }


    static double getAreaByHeron(double a, double b, double c) {
        if (check(a, b, c) == -1) {
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
        if (check(a, b, c) == -1) {
            return new double[]{};
        }
        double h0 = (2 * getAreaByHeron(a, b, c)) / a;
        double h1 = (2 * getAreaByHeron(a, b, c)) / b;
        double h2 = (2 * getAreaByHeron(a, b, c)) / c;

        double[] heightsOfTriangle = new double[]{h0, h1, h2};
        Arrays.sort(heightsOfTriangle);
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
        if (check(a, b, c) == -1) {
            return new double[]{};
        }
        double medianA = 0.5 * (Math.sqrt((2 * Math.pow(b, 2)) + (2 * Math.pow(c, 2)) - Math.pow(a, 2)));
        double medianB = 0.5 * (Math.sqrt((2 * Math.pow(a, 2)) + (2 * Math.pow(c, 2)) - Math.pow(b, 2)));
        double medianC = 0.5 * (Math.sqrt((2 * Math.pow(a, 2)) + (2 * Math.pow(b, 2)) - Math.pow(c, 2)));

        double[] mediansOfTriangle = new double[]{medianA, medianB, medianC};
        Arrays.sort(mediansOfTriangle);
        return mediansOfTriangle;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (check(a, b, c) == -1) {
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
        Arrays.sort(toBisect);
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
        if (check(a, b, c) == -1) {
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

        double[] angles = new double[]{angleAToDegree, angleBToDegree, angleCToDegree};

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
        if (check(a, b, c) == -1) {
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
        if (check(a, b, c) == -1) {
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
