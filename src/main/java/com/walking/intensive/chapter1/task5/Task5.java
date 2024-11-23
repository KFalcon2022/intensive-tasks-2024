package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        double a = 20;
        double b = -10;
        double c = 10;

        System.out.println("Стороны треугольника: " + a + ", " + b + ", " + c);
        System.out.println("Площадь треугольника: " + getAreaByHeron(a, b, c));
        System.out.println("Высоты треугольника: " + Arrays.toString(getHeights(a, b, c)));
        System.out.println("Медианы треугольника: " + Arrays.toString(getMedians(a, b, c)));
        System.out.println("Биссектрисы треугольника: " + Arrays.toString(getBisectors(a, b, c)));
        System.out.println("Углы треугольника: " + Arrays.toString(getAngles(a, b, c)));
        System.out.println("Радиус вписанной окружности: " + getInscribedCircleRadius(a, b, c));
        System.out.println("Радиус описанной окружности: " + getCircumradius(a, b, c));
        System.out.println("Площадь через синус: " + getAreaAdvanced(a, b, c));

    }

    static double getAreaByHeron(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return -1;
        }

        double semiPerimeter = (a + b + c) / 2; //Полупериметр

        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    static double[] getHeights(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return new double[0];
        }

        double[] heightsMassive = new double[3];
        heightsMassive[0] = getAreaByHeron(a, b, c) * 2 / a;
        heightsMassive[1] = getAreaByHeron(a, b, c) * 2 / b;
        heightsMassive[2] = getAreaByHeron(a, b, c) * 2 / c;
        Arrays.sort(heightsMassive);

        return heightsMassive;
    }

    static double[] getMedians(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return new double[0];
        }

        double[] mediansMassive = new double[3];
        mediansMassive[0] = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
        mediansMassive[1] = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
        mediansMassive[2] = Math.sqrt(2 * c * c + 2 * b * b - a * a) / 2;
        Arrays.sort(mediansMassive);
        return mediansMassive;
    }

    static double[] getBisectors(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return new double[0];
        }

        double[] bisectorsMassive = new double[3];
        double[] segmentsMultiplication = new double[3]; //Произведение отрезков стороны, на которую опирается биссектриса
        segmentsMultiplication[0] = ((a * c) / (a + b)) * ((b * c) / (a + b)); // Сторона c
        segmentsMultiplication[1] = ((a * b) / (a + c)) * ((b * c) / (a + c)); // Сторона b
        segmentsMultiplication[2] = ((a * c) / (b + c)) * ((a * b) / (b + c)); // Сторона a
        bisectorsMassive[0] = Math.sqrt(a * b - segmentsMultiplication[0]);
        bisectorsMassive[1] = Math.sqrt(a * c - segmentsMultiplication[1]);
        bisectorsMassive[2] = Math.sqrt(b * c - segmentsMultiplication[2]);
        Arrays.sort(bisectorsMassive);
        return bisectorsMassive;
    }

    static double[] getAngles(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return new double[0];
        }

        double[] angelsMassive = new double[3];
        angelsMassive[0] = Math.acos((b * b + c * c - a * a) / (2 * b * c)) * 180 / Math.PI; //Наименьший угол
        angelsMassive[1] = Math.acos((a * a + c * c - b * b) / (2 * a * c)) * 180 / Math.PI;
        angelsMassive[2] = Math.acos((b * b + a * a - c * c) / (2 * b * a)) * 180 / Math.PI; //Наибольший угол
        Arrays.sort(angelsMassive);
        return angelsMassive;
    }

    static double getInscribedCircleRadius(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return -1;
        }

        return Math.sqrt((-a + b + c) * (a - b + c) * (a + b - c) / (4 * (a + b + c)));
    }

    static double getCircumradius(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return -1;
        }

        double semiPerimeter = (a + b + c) / 2; //Полупериметр

        return (a * b * c) / (4 * Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c)));
    }

    static double getAreaAdvanced(double a, double b, double c) {

        boolean nondegenerateTriangle = (a + b) > c && (a + c) > b && (b + c) > a; //Проверяем условие невырожденного треугольника

        if (!nondegenerateTriangle) {
            return -1;
        }

        double angel = Math.acos((a * a + b * b - c * c) / (2 * a * b)); //Угол в радианах
        double sine = Math.sqrt(1 - Math.pow(Math.cos(angel), 2)); //Синус угла через косинус

        return (a * b * sine) / 2;
    }
}
