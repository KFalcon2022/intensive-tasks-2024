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
        int floorAmount = 2;
        int entranceAmount = 2;
        int flatNumber = 8;
        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int flatAmount = floorAmount * entranceAmount * 4;
        int entranceNumber = 1 + (flatNumber - 1) / (flatAmount / entranceAmount);
        int floorNumber = 1 + ((flatNumber - 1) % (flatAmount / entranceAmount) / 4);
        if (flatAmount < flatNumber) {
            return "Такой квартиры не существует";
        } else if (floorAmount < 1 || entranceAmount < 1 || flatNumber < 1) {
            return "Некорректные входные данные";
        } else if (flatNumber % 4 == 1 || flatNumber % 4 == 2) {
            if (flatNumber % 4 == 1) {
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, слева от лифта, влево";
            } else {
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, слева от лифта, вправо";
            }
        } else if (flatNumber % 4 == 3 || flatNumber % 4 == 0) {
            if (flatNumber % 4 == 3) {
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, справа от лифта, влево";
            } else {
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, справа от лифта, вправо";
            }
        }
        return null;
    }
}
