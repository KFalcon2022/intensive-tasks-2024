package com.walking.intensive.chapter1.task1;

public class Task1 {
    public static void main(String[] args) {

        int age = 10;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        if (age < 0 || age > 127) {
            return "Некорректный ввод";
        }

        if (age % 100 > 10 && age % 100 < 20 || age % 10 > 4 || age % 10 == 0) {
            return "Вам " + age + " лет";
        }

        if (age % 10 > 1) {
            return "Вам " + age + " года";
        }

        return "Вам " + age + " год";
    }
}
