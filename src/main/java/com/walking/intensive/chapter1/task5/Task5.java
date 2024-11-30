package com.walking.intensive.chapter1.task5;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Длина первой стороны: ");
        double a = in.nextDouble();
        System.out.print("Длина второй стороны: ");
        double b = in.nextDouble();
        System.out.print("Длина третьей стороны: ");
        double c = in.nextDouble();

        System.out.println("Площадь треугольника: " + getAreaByHeron(a, b, c));
        System.out.println("Высоты треугольника: " + Arrays.toString(getHeights(a, b, c)));
        System.out.println("Медианы треугольника: " + Arrays.toString(getMedians(a, b, c)));
        System.out.println("Биссектрисы треугольника: " + Arrays.toString(getBisectors(a, b, c)));
        System.out.println("Углы треугольника: " + Arrays.toString(getAngles(a, b, c)));
        System.out.println("Радиус вписаной в треугольник окружности: " + getInscribedCircleRadius(a, b, c));
        System.out.println("Радиус описанной вокруг треугольника окружности: " + getCircumradius(a, b, c));
        System.out.println("Площадь треугольника через синус: " + getAreaAdvanced(a, b, c));

    }

    static double getAreaByHeron(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return -1;
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    static double[] getHeights(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double area = getAreaByHeron(a, b, c);
        double[] heights = new double[3];
        heights[0] = getHeight(a, area);
        heights[1] = getHeight(b, area);
        heights[2] = getHeight(c, area);
        sortArray(heights);

        return heights;
    }

    static double[] getMedians(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double[] medians = new double[3];
        medians[0] = getMedian(a, b, c);
        medians[1] = getMedian(b, c, a);
        medians[2] = getMedian(c, a, b);
        sortArray(medians);

        return medians;
    }

    static double[] getBisectors(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);
        double[] bisectors = new double[3];
        bisectors[0] = getBisector(a, b, c, halfPerimeter);
        bisectors[1] = getBisector(b, c, a, halfPerimeter);
        bisectors[2] = getBisector(c, a, b, halfPerimeter);
        sortArray(bisectors);

        return bisectors;
    }

    static double[] getAngles(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double[] angles = new double[3];
        angles[0] = getAngle(a, b, c);
        angles[1] = getAngle(b, c, a);
        angles[2] = getAngle(c, b, a);
        sortArray(angles);

        return angles;
    }

    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return -1;
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);
        return (getAreaByHeron(a, b, c) / halfPerimeter);
    }


    static double getCircumradius(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return -1;
        }

        double cosC = getCos(c, b, a);
        double sinC = Math.sqrt(1 - cosC * cosC);
        return (c / (2 * sinC));
    }

    static double getAreaAdvanced(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return -1;
        }

        double cosC = getCos(c, a, b);
        double sinC = Math.sqrt(1 - cosC * cosC);
        return (a * b / 2 * sinC);
    }

    static boolean isTriangleExist(double a, double b, double c) {
        return a >= b + c || b >= a + c || c >= a + b;
    }

    static double getHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getCos(double opposite, double adjacent1, double adjacent2) {
        return (adjacent1 * adjacent1 + adjacent2 * adjacent2 - opposite * opposite) / (2 * adjacent1 * adjacent2);
    }

    static double getHeight(double opposite, double area) {
        return area * 2 / opposite;
    }

    static double getMedian(double opposite, double adjacent1, double adjacent2) {
        return Math.sqrt(2 * adjacent2 * adjacent2 + 2 * adjacent1 * adjacent1 - opposite * opposite) / 2;
    }

    static double getBisector(double opposite, double adjacent1, double adjacent2, double halfPerimeter) {
        double sqrt = Math.sqrt(adjacent1 * adjacent2 * halfPerimeter * (halfPerimeter - opposite));
        return 2 * sqrt / (adjacent1 + adjacent2);
    }

    static double getAngle(double opposite, double adjacent1, double adjacent2) {
        double cos = getCos(opposite, adjacent1, adjacent2);
        return Math.toDegrees(Math.acos(cos));
    }

    static void sortArray(double[] doubles) {
        double check1 = doubles[0];
        double check2 = doubles[1];
        double check3 = doubles[2];

        if (check2 < check1 && check2 < check3) {
            doubles[0] = check2;
            doubles[1] = check1;
        } else if (check3 < check1 && check3 < check2) {
            doubles[0] = check3;
            doubles[2] = check1;
        } else {
            doubles[0] = check1;
        }

        if (doubles[2] < doubles[1]) {
            check1 = doubles[1];
            doubles[1] = doubles[2];
            doubles[2] = check1;
        }
    }
}
