package com.walking.intensive.chapter1.task2;

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
    public static void main(String[] args) {

        int amountOfFloors = 5;
        int amountOfEntrances = 4;
        int numOfFlat = 28;
        System.out.println(getFlatLocation(amountOfFloors, amountOfEntrances, numOfFlat));

    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }
        int flatsAmount = floorAmount * entranceAmount * 4;
        if (flatNumber > flatsAmount) {
            return "Такой квартиры не существует";
        }
        int entranceNum;
        int floorNum;
        if (flatNumber % 4 != 0) {
            entranceNum = flatNumber / (floorAmount * 4) + 1;
            floorNum = (flatNumber % (4 * floorAmount)) / 4 + 1;
        } else {
            entranceNum = (flatNumber + (floorAmount * 4 - 1)) / (4 * floorAmount); //подходит для ном. кв. кратных 4
                                                                                    // и в частности посл. на этаже
            floorNum = flatNumber / 4 - (entranceNum - 1) * floorAmount;
        }
        String location = "справа от лифта, вправо";
        int flatLocation = flatNumber % 4;
        location = switch (flatLocation) {
            case 1 -> "слева от лифта, влево";
            case 2 -> "слева от лифта, вправо";
            case 3 -> "справа от лифта, влево";
            default -> location;
        };
        return flatNumber + " кв - " + entranceNum + " подъезд, " + floorNum + " этаж, " + location;

    }
}
