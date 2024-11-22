package com.walking.intensive.chapter1.task4;

public class Task4 {
    public static void main(String[] args) {
        double a = -1;
        double b = 3;
        double c = 4;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {

        String textMessage = "Количество решений: ";

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (a == 0 && b == 0 && c != 0) {
            return textMessage + "0.";
        }

        if (a == 0) {
            double root = -c / b + 0;
            return textMessage + "1. Корень: " + String.format("%.0f", root); //Решаем как линейное уравнение с одним неизвестным
        }

        double discriminant = b * b - 4 * a * c; //Находим дискриминант

        if (discriminant > 0) {
            double firstRoot = (-b - Math.sqrt(discriminant)) / (2 * a); //Находим значение корней
            double secondRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            textMessage = textMessage + "2. Корни: " + String.format("%.0f", Math.min(firstRoot, secondRoot)) + ";" + String.format("%.0f", Math.max(firstRoot, secondRoot));
        } else if (discriminant == 0) {
            double root = (-b - Math.sqrt(discriminant) + 0) / (2 * a); //Значение корня при Д=0
            textMessage = textMessage + "1. Корень: " + String.format("%.0f", root);
        } else {
            textMessage = textMessage + "0.";
        }

        return textMessage;
    }
}