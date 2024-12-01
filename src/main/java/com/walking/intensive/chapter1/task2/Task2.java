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
        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }

        final int flatsOnFloor = 4;
        final int flatsOnEntrance = floorAmount * flatsOnFloor;

        if (flatNumber > flatsOnEntrance * entranceAmount) {
            return "Такой квартиры не существует";
        }

        int entrance = 0;
        for (int i = 0; i < entranceAmount; i++) {
            if ((flatNumber > flatsOnEntrance * i) && (flatNumber <= flatsOnEntrance * (i + 1))) {
                entrance = i + 1;
                break;
            }
        }

        int floor = 0;
        for (int i = 0; i < floorAmount; i++) {
            if ((flatNumber - (entrance - 1) * flatsOnEntrance > flatsOnFloor * i) &&
                    (flatNumber - (entrance - 1) * flatsOnEntrance <= flatsOnFloor * (i + 1))) {
                floor = i + 1;
                break;
            }
        }

        int locationOnFloor = flatNumber - (flatsOnEntrance * (entrance - 1)) - (flatsOnFloor * (floor - 1));
        return switch (locationOnFloor) {
            case 1 -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, слева от лифта, влево";
            case 2 -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, слева от лифта, вправо";
            case 3 -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, справа от лифта, влево";
            default -> flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, справа от лифта, вправо";
        };

    }
}
