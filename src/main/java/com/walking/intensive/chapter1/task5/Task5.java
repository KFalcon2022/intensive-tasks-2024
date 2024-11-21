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


        System.out.println(getAreaByHeron(a, b, c));
        System.out.println();

        double[] heights = getHeights(a, b, c);
        for (double height : heights) {
            System.out.println(height);
        }
        System.out.println();

        double[] medians = getMedians(a,b,c);
        for (double median : medians) {
            System.out.println(median);
        }
        System.out.println();

        double[] bisectors = getBisectors(a, b, c);
        for (double bisector : bisectors) {
            System.out.println(bisector);
        }
    }

    static double a = 3;
    static double b = 4;
    static double c = 5;

    static double areaByHeron = getAreaByHeron(a, b, c);


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
        if (a <= 0 || b <= 0 || c <= 0 || !isTriangle(a,b,c)) return -1;
        double perimeter = (a + b + c) / 2;

        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || !isTriangle(a,b,c)) return new double[0];

        double[] heights = new double[3];

        heights[0] = 2 * areaByHeron / a;
        heights[1] = 2 * areaByHeron / b;
        heights[2] = 2 * areaByHeron / c;

        Arrays.sort(heights);

        return heights;
    }

    public static boolean isTriangle(double a, double b, double c) {

        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || !isTriangle(a,b,c)) return new double[0];

        double medianA = Math.sqrt((2 * b * b + 2 * c * c - a * a)) / 2;
        double medianB = Math.sqrt((2 * a * a + 2 * c * c - b * b)) / 2;
        double medianC = Math.sqrt((2 * a * a + 2 * b * b - c * c)) / 2;

        double[] medians = {medianA, medianB, medianC};

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
        if (a <= 0 || b <= 0 || c <= 0 || !isTriangle(a,b,c)) return new double[0];


        double bisectorA = Math.sqrt(b * c * (1 - a * a / Math.pow(b + c, 2)));
        double bisectorB = Math.sqrt(a * c * (1 - b * b / Math.pow(a + c, 2)));
        double bisectorC = Math.sqrt(a * b * (1 - c * c / Math.pow(a + b, 2)));

        double[] bisectors = {bisectorA, bisectorB, bisectorC};

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
        //        Место для вашего кода

        return null; // Заглушка. При реализации - удалить
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
