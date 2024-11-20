package com.walking.intensive.chapter1.task1;

public class Task1 {
    public static void main(String[] args) {
        int age = 3;
        System.out.println(getAgeString(age));
    }
    static String getAgeString(int age) {
        if (age < 0) {
                return "Некорректный ввод";
        }   if (age > 10 && age < 15) {
                return "Вам "+ age +" лет";
        }   if (age > 110 && age < 115) {
                return "Вам "+ age +" лет";
        }
        int lastNum = age % 10;
        switch (lastNum) {
            case 0:
                return "Вам "+ age +" лет";
            case 1:
                return "Вам "+ age +" год";
            case 2 | 3 | 4:
                return "Вам "+ age +" года";
            case 3:
                return "Вам "+ age +" года";
            case 4:
                return "Вам "+ age +" года";
            default:
                return "Вам "+ age +" лет";

        }
    }
}
