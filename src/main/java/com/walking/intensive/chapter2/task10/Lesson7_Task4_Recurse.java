package com.walking.intensive.chapter2.task10;

public class Lesson7_Task4_Recurse {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(calculateArg(n));
        System.out.println(calculateExpression(n));
    }

    static double calculateExpression(int number) {
        return calculateExpression(1, number);
    }

    //    Реализуем рекурсивный метод, второй параметр которого необходим,
//    но всегда известен для первого вызова
    static double calculateExpression(int number, int maxNumber) {
        if (number == maxNumber) {
            return Math.sqrt(number);
        }
        return Math.sqrt(number + calculateExpression(number + 1, maxNumber));
    }

    public static double calculateArg(int n) {
        if (n == 0) {
            return Math.sqrt(n);
        }
        return Math.sqrt(calculateArg(n-1) + Math.sqrt(n));
    }
}
