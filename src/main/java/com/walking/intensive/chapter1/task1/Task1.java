package com.walking.intensive.chapter1.task1;

public class Task1 {
    public static void main(String[] args) {

        int age = 12;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        if (age >= 0) {
            String result = "Вам " + age;
            if (age % 10 == 1 && age != 11) {
                result = result + " год";
            } else if ((age % 10 == 2 || age % 10 == 3 || age % 10 == 4) && age != 12 && age != 13 && age != 14) {
                result = result + " года";
            } else {
                result = result + " лет";
            }
            return result;
        } else {
            return "Некорректный ввод";
        }

    }
}
