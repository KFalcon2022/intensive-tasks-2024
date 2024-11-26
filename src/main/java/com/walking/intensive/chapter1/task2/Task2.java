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
        var string1 = "справа от лифта, вправо";
        var string2 = "слева от лифта, влево";
        var string3 = "слева от лифта, вправо";
        var string4 = "справа от лифта, влево";
        var direction = "default";
        switch (flatNumber % 4) {
            case 0:
                direction = string1;
                break;
            case 1:
                direction = string2;
                break;
            case 2:
                direction = string3;
                break;
            default:
                direction = string4;
        }
        return String.format("%d кв - %d подъезд, %d этаж, " + direction, flatNumber, numberEnterance, level);
    }
}
