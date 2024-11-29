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

        double height1 = getHeight(a, b, c);
        double height2 = getHeight(b, c, a);
        double height3 = getHeight(c, b, a);

        double[] heights = new double[3];
        heights[0] = height1;
        heights[1] = height2;
        heights[2] = height3;
        sortArray(heights[0], heights[1], heights[2]);

        return heights;
    }

    static double[] getMedians(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double median1 = getMedian(a, b, c);
        double median2 = getMedian(b, c, a);
        double median3 = getMedian(c, a, b);

        double[] medians = new double[3];
        medians[0] = median1;
        medians[1] = median2;
        medians[2] = median3;
        sortArray(medians[0], medians[1], medians[2]);

        return medians;
    }

    static double[] getBisectors(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double bisector1 = getBisector(a, b, c);
        double bisector2 = getBisector(b, c, a);
        double bisector3 = getBisector(c, a, b);

        double[] bisectors = new double[3];
        bisectors[0] = bisector1;
        bisectors[1] = bisector2;
        bisectors[2] = bisector3;
        sortArray(bisectors[0], bisectors[1], bisectors[2]);

        return bisectors;
    }

    static double[] getAngles(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            return new double[0];
        }

        double angle1 = getAngle(a, b, c);
        double angle2 = getAngle(b, c, a);
        double angle3 = getAngle(c, b, a);

        double[] angles = new double[3];
        angles[0] = angle1;
        angles[1] = angle2;
        angles[2] = angle3;
        sortArray(angles[0], angles[1], angles[2]);

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

    static double getHeight (double opposite, double adjacent1, double adjacent2) {
        double area = getAreaByHeron(opposite, adjacent1, adjacent2);
        return area * 2 / opposite;
    }

    static double getMedian (double opposite, double adjacent1, double adjacent2) {
        return Math.sqrt(2 * adjacent2 * adjacent2 + 2 * adjacent1 * adjacent1 - opposite * opposite) / 2;
    }

    static double getBisector (double opposite, double adjacent1, double adjacent2) {
        double halfPerimeter = getHalfPerimeter(opposite, adjacent1, adjacent2);
        return 2 * Math.sqrt(adjacent1 * adjacent2 * halfPerimeter * (halfPerimeter - opposite)) / (adjacent1 + adjacent2);
    }

    static double getAngle (double opposite, double adjacent1, double adjacent2) {
        double cos = getCos(opposite, adjacent1, adjacent2);
        return Math.toDegrees(Math.acos(cos));
    }

    static void sortArray(double doubles1, double doubles2, double doubles3) {
        double check1 = doubles1;
        double check2 = doubles2;
        double check3 = doubles3;

        if (check2 < check1 && check2 < check3) {
            doubles1 = check2;
        } else if (check3 < check1 && check3 < check2) {
            doubles1 = check3;
        } else {
            doubles1 = check1;
        }

        if (check1 > check2 && check1 > check3) {
            doubles3 = check1;
        } else if (check2 > check1 && check2 > check3) {
            doubles3 = check2;
        } else {
            doubles3 = check3;
        }

        if (doubles1 != check1 && doubles3 != check1) {
            doubles2 = check1;
        } else if (doubles1 != check2 && doubles3 != check2) {
            doubles2 = check2;
        } else {
            doubles2 = check3;
        }

    }

}
