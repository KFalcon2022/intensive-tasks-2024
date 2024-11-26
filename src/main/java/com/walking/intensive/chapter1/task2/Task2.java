package com.walking.intensive.chapter1.task2;

public class Task2 {
    public static void main(String[] args) {
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if (flatNumber <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }
        if (floorAmount * entranceAmount * 4 < flatNumber) {
            return "Такой квартиры не существует";
        }
        int oneEnterance = floorAmount * 4; // квартир в одном подъезде
        int numberEnterance = flatNumber / oneEnterance; // подъезд
        if (flatNumber % oneEnterance > 0) {
            numberEnterance = numberEnterance + 1;
        }
        int level = (flatNumber / 4);
        if ((flatNumber % 4) > 0) {
            level = ++level;
        }
        if (level > floorAmount) {
            level = level % floorAmount;
        }
        Object string1, string2, string3, string4;
        string1 = "справа от лифта, вправо";
        string2 = "слева от лифта, влево";
        string3 = "слева от лифта, вправо";
        string4 = "справа от лифта, влево";
        switch (flatNumber % 4) {
            case 0:
                return String.format("%d кв - %d подъезд, %d этаж, " + string1, flatNumber, numberEnterance, level);
            case 1:
                return String.format("%d кв - %d подъезд, %d этаж, " + string2, flatNumber, numberEnterance, level);
            case 2:
                return String.format("%d кв - %d подъезд, %d этаж, " + string3, flatNumber, numberEnterance, level);
            default:
                return String.format("%d кв - %d подъезд, %d этаж, " + string4, flatNumber, numberEnterance, level);
        }
    }
}
