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

        System.out.println(getFlatLocation(3, 2, 16));

    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int maxFlatNumber = floorAmount * entranceAmount * 4;
        int flatOneEntrance = floorAmount * 4;

        if (flatNumber <= 0 || floorAmount <= 0 || entranceAmount <= 0) {
            return "Некорректные входные данные";
        }
        if (flatNumber > maxFlatNumber) {
            return "Такой квартиры не существует";
        }

        // номер подъезда
        int entranceNumber = flatNumber / flatOneEntrance;
        if (flatNumber / maxFlatNumber < 1) {
            entranceNumber++;
        }

        // номер этажа без учета разделения на подъезды
        int commonFloorNumber = flatNumber / 4;
        if (flatNumber % 4 != 0) {
            commonFloorNumber++;
        }

        // номер этажа с учетом разделения на подъезды
        int floorNumber = commonFloorNumber - floorAmount * (entranceNumber - 1);
        // положение квартиры относительно этажа (1,2,3,4)
        int direction = flatNumber - (commonFloorNumber - 1) * 4;


        String direction1 = "слева от лифта, ";
        String direction3 = "влево";
        String direction4 = "вправо";
        String direction2 = "справа от лифта, ";

        switch (direction) {
            case 1:
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + direction1 + direction3;
            case 2:
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + direction1 + direction4;
            case 3:
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + direction2 + direction3;
            case 4:
                return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + direction2 + direction4;

        }
        return "";
    }
}
