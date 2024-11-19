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
        System.out.println(getFlatLocation(5, 2, 1));

    }

    static String getFlatLocation(int floors, int entrances, int flatNumber) {
        //        Место для вашего кода
        final int FLATS_PER_FLOOR = 4;
        final int INDEX_OFFSET = 1;
        if (floors <= 0 || entrances <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }

        int flatsPerEntrance = floors * FLATS_PER_FLOOR;

        if (flatNumber > flatsPerEntrance * entrances) {
            return "Такой квартиры не существует";
        }

        int entrance = (flatNumber - INDEX_OFFSET) / flatsPerEntrance + 1;
        int flatWithinEntrance = (flatNumber - INDEX_OFFSET) % flatsPerEntrance + 1;
        int floor = (flatWithinEntrance - INDEX_OFFSET) / 4 + 1;
        int positionOnFloor = (flatWithinEntrance - INDEX_OFFSET) % 4;

// Вычисляю сторону относительно лифта
        String side;
        switch (positionOnFloor) {
            case 0, 1 -> side = "слева от лифта";
            case 2, 3 -> side = "справа от лифта";
            default -> side = "ты не туда попал";
        }

// Определяю направление (влево или вправо)
        String direction;
        if (positionOnFloor % 2 == 0) {
            direction = "влево"; // Чётные позиции: 0, 2
        } else {
            direction = "вправо"; // Нечётные позиции: 1, 3
        }
        return String.format("%d подъезд, %d этаж, %s, %s", entrance, floor, side, direction);
    }
}
