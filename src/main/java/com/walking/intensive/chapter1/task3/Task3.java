package com.walking.intensive.chapter1.task3;
public class Task3 {
    public static void main(String[] args) {

        System.out.println(isLeap(2024));
    }

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
