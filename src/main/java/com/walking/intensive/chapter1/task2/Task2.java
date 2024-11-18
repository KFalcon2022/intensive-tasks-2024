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
        System.out.println(getFlatLocation(3, 3, 35));

    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода
        final int FLATS_PER_FLOOR = 4;

        if (floorAmount < 1 || entranceAmount < 1 || flatNumber < 1) {
            return "Некорректные входные данные";
        }

        if (flatNumber > floorAmount * entranceAmount * FLATS_PER_FLOOR) {
            return "Такой квартиры не существует";
        }

        int entrance = (flatNumber - 1) / FLATS_PER_FLOOR / floorAmount + 1;
        int floor = ((flatNumber - 1) / FLATS_PER_FLOOR) % floorAmount + 1;

        String turnFromElevator;
        switch (flatNumber % 4) {
            case 1, 2 -> turnFromElevator = "слева от лифта, ";
            default -> turnFromElevator = "справа от лифта, ";
        }

        String finalTurn;
        if (flatNumber % 2 == 0) {
            finalTurn = "вправо";
        } else {
            finalTurn = "влево";
        }

        return flatNumber + " кв - " +
                entrance + " подъезд, " +
                floor + " этаж, " +
                turnFromElevator +
                finalTurn;
    }
}
