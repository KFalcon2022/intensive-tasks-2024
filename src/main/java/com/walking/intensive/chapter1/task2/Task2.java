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

        System.out.println(getFlatLocation(7, 4, 1));
        System.out.println(getFlatLocation(7, 4, 2));
        System.out.println(getFlatLocation(7, 4, 3));
        System.out.println(getFlatLocation(7, 4, 4));
        System.out.println(getFlatLocation(7, 4, 5));
        System.out.println(getFlatLocation(7, 4, 6));
        System.out.println(getFlatLocation(7, 4, 7));
        System.out.println(getFlatLocation(7, 4, 8));
        System.out.println(getFlatLocation(7, 4, 9));
        System.out.println(getFlatLocation(7, 4, 10));
        System.out.println(getFlatLocation(7, 4, 11));
        System.out.println(getFlatLocation(7, 4, 12));
        System.out.println(getFlatLocation(7, 4, 73));
        System.out.println(getFlatLocation(7, 4, 80));
        System.out.println(getFlatLocation(7, 4, 84));
        System.out.println(getFlatLocation(7, 4, 90));
        System.out.println(getFlatLocation(7, 4, 96));
        System.out.println(getFlatLocation(7, 4, 100));
        System.out.println(getFlatLocation(7, 4, 111));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int numberFlatInHouse = 4; // количество квартир
        int numberFloor; // какой этаж
        int numberEntranceHouse;  // в каком подъезде квартира

        if (flatNumber > (floorAmount * entranceAmount * numberFlatInHouse)) { // валидация
            return "Такой квартиры не существует";
        }
        if (flatNumber <= 0 || floorAmount <= 0 || entranceAmount <= 0) {
            return "Некорректные входные данные";
        }

        numberEntranceHouse = flatNumber / (floorAmount * numberFlatInHouse); // номер подъезда
        if (flatNumber % (floorAmount * numberFlatInHouse) > 0) {
            numberEntranceHouse++;
        }

        if (numberEntranceHouse > 1) { // какой этаж
            numberFloor = (flatNumber / numberFlatInHouse) - ((numberEntranceHouse - 1) * floorAmount);
            if ((double) flatNumber % numberFlatInHouse > 0) {
                numberFloor++;
            }
        } else {
            numberFloor = flatNumber / numberFlatInHouse;
            if ((double) flatNumber % numberFlatInHouse > 0) {
                numberFloor++;
            }
        }

        if (flatNumber == 1 | flatNumber % numberFlatInHouse == 1) {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, слева от лифта, влево";
        }
        if (flatNumber == 2 | flatNumber % numberFlatInHouse == 2) {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, слева от лифта, вправо";
        }
        if (flatNumber == 3 | flatNumber % numberFlatInHouse == 3) {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, справа от лифта, влево";
        } else {
            return flatNumber + " кв – " + numberEntranceHouse + " подъезд, " + numberFloor + " этаж, справа от лифта, вправо";
        }
    }
}
