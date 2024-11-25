package com.walking.intensive.chapter1.task3;

public class Task3 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static boolean isLeap(int year) {
        //Место для вашего кода
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
