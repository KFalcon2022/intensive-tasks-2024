package com.walking.intensive.chapter1.task2;

import java.util.Scanner;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    static final int FLATS_ON_THE_FLOR = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter floor amount:");
        int floorAmount = scanner.nextInt();

        System.out.println("Enter entrance amount:");
        int entranceAmount = scanner.nextInt();

        System.out.println("Enter flat number:");
        int flatNumber = scanner.nextInt();

        scanner.close();

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if (!validate(floorAmount, entranceAmount, flatNumber)) {
            return "Некорректные входные данные";
        }

        int quantityAllFlats = floorAmount * entranceAmount * FLATS_ON_THE_FLOR;

        if (flatNumber > quantityAllFlats) {
            return "Такой квартиры не существует";
        }

        int flatsInEntrance = floorAmount * FLATS_ON_THE_FLOR;
        int currentEntrance = (int) Math.ceil((double) flatNumber / flatsInEntrance);
        int currentFloor = (int) Math.ceil((double) (flatNumber - (flatsInEntrance * (currentEntrance - 1))) / FLATS_ON_THE_FLOR);

        return printFlatLocation(currentEntrance, currentFloor, flatNumber);
    }

    static String printFlatLocation(int currentEntrance, int currentFloor, int flatNumber) {
        String flatLocation = flatNumber + " кв - " + currentEntrance + " подъезд, " + currentFloor + " этаж, ";

        switch (flatNumber % FLATS_ON_THE_FLOR) {
            case 1:
                flatLocation += "слева от лифта, влево";
                break;
            case 2:
                flatLocation += "слева от лифта, вправо";
                break;
            case 3:
                flatLocation += "справа от лифта, влево";
                break;
            case 0:
                flatLocation += "справа от лифта, вправо";
        }


        return flatLocation;
    }

    static boolean validate(int floorAmount, int entranceAmount, int flatNumber) {
        return floorAmount > 0 && entranceAmount > 0 && flatNumber > 0;
    }
}
