package com.walking.intensive.chapter1.task1;

public class Task1 {
    public static void main(String[] args) {
        int age = 2;
        System.out.println(getAgeString(age));
    }

    @SuppressWarnings("checkstyle:Indentation")
    static String getAgeString(int age) {
        if (age < 0) {
            return "Некорректный ввод";
        }
        if (age % 100 > 10 && age % 100 < 15) {
            return "Вам " + age + " лет";
        }
        int lastNum = age % 10;
        switch (lastNum) {
            case 0:
                return "Вам " + age + " лет";
            case 1:
                return "Вам " + age + " год";
            case 2:
            case 3:
            case 4:
                return "Вам " + age + " года";
            default:
                return "Вам " + age + " лет";
        }
    }
}
