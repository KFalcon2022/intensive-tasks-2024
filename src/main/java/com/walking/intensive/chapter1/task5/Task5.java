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

    static void isTriangleExist (double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println(-1);
        }
    }

    static void isTriangleExist2 (double a, double b, double c) {

        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println(Arrays.toString(new double[0]));
        }
    }

    static void sortArrays (double doubles1, double doubles2, double doubles3) {
        double[] doubles = new double[3];
        if (doubles1 < doubles2 && doubles1 < doubles3)  {
            doubles[0] = doubles1;
        } else if (doubles2 < doubles1 && doubles2 < doubles3) {
            doubles[0] = doubles2;
        } else {
            doubles[0] = doubles3;
        }

        if (doubles1 > doubles2 && doubles1 > doubles3) {
            doubles[2] = doubles1;
        } else if (doubles2 > doubles1 && doubles2 > doubles3) {
            doubles[2] = doubles2;
        } else {
            doubles[2] = doubles3;
        }

        if (doubles[0] != doubles1 && doubles[2] != doubles1) {
            doubles[1] = doubles1;
        } else if (doubles[0] != doubles2 && doubles[2] != doubles2) {
            doubles[1] = doubles2;
        } else {
            doubles[1] = doubles3;
        }
    }

    static double getAreaByHeron(double a, double b, double c) {
        isTriangleExist(a, b, c);

        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));

    }

    static double[] getHeights(double a, double b, double c) {
        isTriangleExist2(a, b, c);

        double area = getAreaByHeron(a, b, c);
        double doubles1 = area * 2 / a;
        double doubles2 = area * 2 / b;
        double doubles3 = area * 2 / c;

        double[] doubles = new double[0];
        sortArrays(doubles1, doubles2, doubles3);

        return doubles;

    }

    static double[] getMedians(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            return new double[0];
        }

        double[] medians = new double[3];
        medians[0] = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
        medians[1] = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
        medians[2] = Math.sqrt(2 * c * c + 2 * b * b - a * a) / 2;
        Arrays.sort(medians);

        return medians;
    }

    static double[] getBisectors(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            return new double[0];
        }

        double halfPerimeter = (a + b + c) / 2;
        double[] bisectors = new double[3];
        bisectors[0] = 2 * Math.sqrt(a * b * halfPerimeter * (halfPerimeter - c)) / (a + b);
        bisectors[1] = 2 * Math.sqrt(a * c * halfPerimeter * (halfPerimeter - b)) / (a + c);
        bisectors[2] = 2 * Math.sqrt(c * b * halfPerimeter * (halfPerimeter - a)) / (c + b);
        Arrays.sort(bisectors);

        return bisectors;

    }


    static double[] getAngles(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            return new double[0];
        }

        double cosC = (a * a + b * b - c * c) / (2 * a * b);
        double cosB = (a * a + c * c - b * b) / (2 * a * c);

        double[] angles = new double[3];
        angles[0] = Math.toDegrees(Math.acos(cosC));
        angles[1] = Math.toDegrees(Math.acos(cosB));
        angles[2] = 180 - angles[0] - angles[1];
        Arrays.sort(angles);

        return angles;
    }

    static double getInscribedCircleRadius(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            return -1;
        }

        double halfPerimeter = (a + b + c) / 2;

        return (getAreaByHeron(a, b, c) / halfPerimeter);
    }


    static double getCircumradius(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            return -1;
        }

        double cosC = (a * a + b * b - c * c) / (2 * a * b);
        double sinC = Math.sqrt(1 - cosC * cosC);

        return (c / (2 * sinC));
    }

    static double getAreaAdvanced(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            return -1;
        }

        double cosC = (a * a + b * b - c * c) / (2 * a * b);
        double sinC = Math.sqrt(1 - cosC * cosC);

        return (a * b / 2 * sinC);
    }

}