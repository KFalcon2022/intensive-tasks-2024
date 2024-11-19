package com.walking.intensive.chapter1.task1;

public class Task1 {
    public static void main(String[] args) {

        int age = 1111;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        String result = "Вам " + age;
        int m = age % 10;
        int o = age % 100;

        if (age < 0) {
            return "Некорректный ввод";
        }
        if (m == 1 && o != 11) {
            result = result + " год";
        } else if ((m == 2 || m == 3 || m == 4) && o != 12 && o != 13 && o != 14)
            result = result + " года";
        else {
            result = result + " лет";
        }
        return result;
    }

}

