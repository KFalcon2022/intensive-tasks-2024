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

    static double getAreaByHeron(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            double halfPerimeter = getHalfPerimeter(a, b, c);
            return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        }

        return -1;
    }

    static double[] getHeights(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double area = getAreaByHeron(a, b, c);
            double height1 = area * 2 / a;
            double height2 = area * 2 / b;
            double height3 = area * 2 / c;
            sortArray(height1, height2, height3);

            double[] heights = new double[3];
            heights[0] = height1;
            heights[1] = height2;
            heights[2] = height3;

            return heights;
        }

        return new double[0];
    }

    static double[] getMedians(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double median1 = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
            double median2 = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
            double median3 = Math.sqrt(2 * c * c + 2 * b * b - a * a) / 2;
            sortArray(median1, median2, median3);

            double[] medians = new double[3];
            medians[0] = median1;
            medians[1] = median2;
            medians[2] = median3;

            return medians;
        }

        return new double[0];
    }

    static double[] getBisectors(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double halfPerimeter = getHalfPerimeter(a, b, c);

            double bisector1 = 2 * Math.sqrt(a * b * halfPerimeter * (halfPerimeter - c)) / (a + b);
            double bisector2 = 2 * Math.sqrt(a * c * halfPerimeter * (halfPerimeter - b)) / (a + c);
            double bisector3 = 2 * Math.sqrt(c * b * halfPerimeter * (halfPerimeter - a)) / (c + b);
            sortArray(bisector1, bisector2, bisector3);

            double[] bisectors = new double[3];
            bisectors[0] = bisector1;
            bisectors[1] = bisector2;
            bisectors[2] = bisector3;

            return bisectors;
        }

        return new double[0];
    }

    static double[] getAngles(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double cosC = getCos(a, b, c);
            double cosB = getCos(a, c, b);

            double angle1 = Math.toDegrees(Math.acos(cosC));
            double angle2 = Math.toDegrees(Math.acos(cosB));
            double angle3 = 180 - angle1 - angle2;
            sortArray(angle1, angle2, angle3);

            double[] angles = new double[3];
            angles[0] = angle1;
            angles[1] = angle2;
            angles[2] = angle3;

            return angles;
        }

        return new double[0];
    }

    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double halfPerimeter = getHalfPerimeter(a, b, c);

            return (getAreaByHeron(a, b, c) / halfPerimeter);
        }

        return -1;
    }


    static double getCircumradius(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double cosC = getCos(a, b, c);
            double sinC = Math.sqrt(1 - cosC * cosC);

            return (c / (2 * sinC));
        }

        return -1;
    }

    static double getAreaAdvanced(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double cosC = getCos(a, b, c);
            double sinC = Math.sqrt(1 - cosC * cosC);

            return (a * b / 2 * sinC);
        }

        return -1;
    }

    static boolean isTriangleExist(double a, double b, double c) {
        return a < b + c && b < a + c && c < a + b;
    }

    static double getHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getCos(double adjacent1, double adjacent2, double hypotenuse) {
        return (adjacent1 * adjacent1 + adjacent2 * adjacent2 - hypotenuse * hypotenuse) / (2 * adjacent1 * adjacent2);
    }
}
