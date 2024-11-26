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
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //проверяем данные
        if (floorAmount <= 0 | entranceAmount <= 0 | flatNumber <= 0) {
            return "Некорректные входные данные";
        }

        int apartmentsAmount = floorAmount * entranceAmount * 4;
        if (flatNumber > apartmentsAmount) {
            return "Такой квартиры не существует";
        }

        //находим подъезд
        int entrance;
        int amountApartmentsOnFloor = 4;
        int apartmentsAmountEntrance = floorAmount * amountApartmentsOnFloor;
        if (flatNumber % apartmentsAmountEntrance == 0) {
            entrance = flatNumber / apartmentsAmountEntrance;
        } else {
            entrance = (flatNumber / apartmentsAmountEntrance) + 1;
        }

        //находим этаж
        int floor;
        if (flatNumber % amountApartmentsOnFloor == 0) {
            floor = (flatNumber - (apartmentsAmountEntrance * (entrance - 1))) / amountApartmentsOnFloor;
        } else {
            floor = ((flatNumber - (apartmentsAmountEntrance * (entrance - 1))) / amountApartmentsOnFloor) + 1;
        }

        //возвращаем местоположение квартиры
        return switch (flatNumber % 4) {
            case (0) -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " + "справа от лифта, вправо";
            case (1) -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " + "слева от лифта, влево";
            case (2) -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " + "слева от лифта, вправо";
            case (3) -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " + "справа от лифта, влево";
            default -> null;
        };
    }
}
