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
        int floor = 10;
        System.out.println(getFlatLocation(floor, 4, 16));

    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода
        int allFlats = floorAmount * entranceAmount * 4;
        if (allFlats < flatNumber) {
            return "Такой квартиры не существует";
        } else if (flatNumber < 1 || floorAmount < 1 || entranceAmount < 1) {
            return "Некорректные входные данные";
        }

        int floor = ((flatNumber - 1) % (floorAmount * 4)) / 4 + 1;
        int entrance = (flatNumber - 1) / (floorAmount * 4) + 1;
        int direction = flatNumber % 4;
        return switch (direction) {
            case 1 -> "%d кв - %d подъезд, %d этаж, слева от лифта, влево".formatted(flatNumber, entrance, floor);
            case 2 -> "%d кв – %d подъезд, %d этаж, слева от лифта, вправо".formatted(flatNumber, entrance, floor);
            case 3 -> "%d кв – %d подъезд, %d этаж, справа от лифта, влево".formatted(flatNumber, entrance, floor);
            case 0 -> "%d кв - %d подъезд, %d этаж, справа от лифта, вправо".formatted(flatNumber, entrance, floor);
            default -> null;
        };
    }

}
