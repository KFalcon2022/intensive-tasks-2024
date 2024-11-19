package com.walking.intensive.chapter1.task2;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(getFlatLocation(10, 3, 0));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int flatInEntrance = floorAmount * 4;

        if (floorAmount < 1 || entranceAmount < 1 || flatNumber < 1) {
            return "Некорректные входные данные";
        }
        if (flatNumber > entranceAmount * flatInEntrance) {
            return "Такой квартиры не существует";
        }

        int entrance = (flatNumber / flatInEntrance);
        if (flatNumber % flatInEntrance != 0) {
            entrance = entrance + 1;
        }
        int floor = ((flatNumber - (entrance - 1) * flatInEntrance) - 1) / 4 + 1;

        String fromElevator;
        if (flatNumber % 4 == 1 || flatNumber % 4 == 2) {
            fromElevator = "слева от лифта";
        } else {
            fromElevator = "справа от лифта";
        }
        String side;
        if (flatNumber % 2 == 0) {
            side = "вправо";
        } else {
            side = "влево";
        }
        return flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " + fromElevator + ", " + side;
    }
}

