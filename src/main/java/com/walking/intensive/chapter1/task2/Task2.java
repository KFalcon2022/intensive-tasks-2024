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
        int floorAmount = 10;
        int entranceAmount = 3;
        int flatNumber = -1;
        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if (flatNumber > floorAmount * entranceAmount * 4) {
            return "Такой квартиры не существует";
        }

        if (flatNumber <= 0) {
            return "Некорректные входные данные";
        }

        int numEntrance = (int) Math.ceil(1.0 * flatNumber / floorAmount / 4);

        int numFloor = (int) Math.ceil(1.0 * flatNumber / 4 - (numEntrance - 1) * floorAmount);

        int numElevatorDirection = (int) Math.ceil(1.0 * flatNumber / 2 - (numEntrance - 1) * floorAmount * 2
                - (numFloor - 1) * 2);
        String nameElevatorDirection = numElevatorDirection == 1 ? "слева от лифта" : "справа от лифта";

        int numDirection = (int) Math.ceil(1.0 * flatNumber - (numEntrance - 1) * floorAmount * 4
                - (numFloor - 1) * 4) % 2;
        String nameDirection = numDirection == 0 ? "вправо" : "влево";

        return String.valueOf(flatNumber) + " кв - " + String.valueOf(numEntrance) + " подъезд, "
                + String.valueOf(numFloor) + " этаж, " + nameElevatorDirection + ", " + nameDirection;
    }
}
