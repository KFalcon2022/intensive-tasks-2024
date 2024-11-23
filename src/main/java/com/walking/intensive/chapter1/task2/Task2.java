package com.walking.intensive.chapter1.task2;

@SuppressWarnings("checkstyle:WhitespaceAround")
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
        switch (flatNumber % 4) {
            case 0:
                return flatNumber + " кв - " + numberEnterance + " подъезд, " + level + " этаж, справа от лифта, вправо";
            case 1:
                return flatNumber + " кв - " + numberEnterance + " подъезд, " + level + " этаж, слева от лифта, влево";
            case 2:
                return flatNumber + " кв - " + numberEnterance + " подъезд, " + level + " этаж, слева от лифта, вправо";
            default:
                return flatNumber + " кв - " + numberEnterance + " подъезд, " + level + " этаж, справа от лифта, вправо";
        }
    }
}