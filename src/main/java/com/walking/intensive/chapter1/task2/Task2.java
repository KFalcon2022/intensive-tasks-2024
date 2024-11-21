package com.walking.intensive.chapter1.task2;

public class Task2 {
    public static void main(String[] args) {

        int floorAmount = 9;
        int entranceAmount = 4;
        int flatNumber = 7;

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        String textMessage = flatNumber + " кв - ";

        if (flatNumber < 1 || floorAmount < 1 || entranceAmount < 1) {
            textMessage = "Некорректные входные данные";
            return textMessage;
        }

        if (flatNumber > floorAmount * entranceAmount * 4) { //Максимальное число квартир в доме из расчета 4 квартир на этаже
            textMessage = "Такой квартиры не существует";
            return textMessage;
        }

        int flatEntrance = (flatNumber + floorAmount * 4 - 1) / (floorAmount * 4); //Определяем номер подъезда
        int flatFloor = (flatNumber + 3) / 4 - ((flatEntrance - 1) * floorAmount); //Определяем этаж в найденном подъезде
        int flatCorner = flatNumber % 4; //Определяем расположение квартиры на этаже

        textMessage = textMessage + flatEntrance + " подъезд, " + flatFloor + " этаж, ";

        switch (flatCorner) {
            case (1):
                textMessage = textMessage + "слева от лифта, влево";
                break;
            case (2):
                textMessage = textMessage + "слева от лифта, вправо";
                break;
            case (3):
                textMessage = textMessage + "справа от лифта, влево";
                break;
            case (0):
                textMessage = textMessage + "справа от лифта, вправо";
                break;
        }

        return textMessage;
    }
}