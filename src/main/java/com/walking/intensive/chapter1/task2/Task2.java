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

        System.out.println(getFlatLocation(7,4,29));
        System.out.println(getFlatLocation(7,4,56));
        System.out.println(getFlatLocation(7,4,57));
        System.out.println(getFlatLocation(7,4,84));
        System.out.println(getFlatLocation(7,4,85));
        System.out.println(getFlatLocation(7,4,30));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int numberFlat = 4; // количество квартир

        if (flatNumber > (floorAmount * entranceAmount * numberFlat)) {
            return "Такой квартиры не существует";
        }
        if (flatNumber <= 0 || floorAmount <= 0 || entranceAmount <= 0) {
            return "Некорректные входные данные";
        }

        int numberEntranceHouse = flatNumber / (floorAmount * numberFlat); // в каком подъезде квартира
        if (flatNumber % (floorAmount * numberFlat) > 0) {
            numberEntranceHouse++;
        }

        int numberFloor = flatNumber / numberFlat;// какой этаж
        System.out.println(numberFloor);
        if (flatNumber % numberFlat > 0) {
            numberFloor++;
        }
        if (numberFloor > floorAmount){ // ?????
            numberFloor = (entranceAmount * floorAmount) - numberFloor;
        }

        if (flatNumber % numberFlat == 0) {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, слева от лифта, влево";
        }if (flatNumber % numberFlat == 1) {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, слева от лифта, вправо";
        }if (flatNumber % numberFlat == 2) {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, справа от лифта, влево";
        }else {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, справа от лифта, вправо";
        }
    }
}
