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
        if (floorAmount < 1 || entranceAmount < 1 || flatNumber < 1) {
            return "Некорректные входные данные";
        }

        int apartments = floorAmount * entranceAmount * 4;

        if (flatNumber > apartments) {
            return "Такой квартиры не существует";
        }

        int floor = (int) Math.ceil((double) flatNumber / 4);           //ищем этаж

        int entrance = 1;

        if (floor > floorAmount) {                                       //ищем подъезд
            while (floor > floorAmount) {
                floor = floor - floorAmount;
                entrance++;
            }
        }

        int apartmentLocation = flatNumber % 4;             //ищем раположение кваритры

        return switch (apartmentLocation) {
            case 1 -> String.format("%d кв - %d подъезд, %d этаж, слева от лифта, влево", flatNumber, entrance, floor);
            case 2 -> String.format("%d кв - %d подъезд, %d этаж, слева от лифта, вправо", flatNumber, entrance, floor);
            case 3 -> String.format("%d кв - %d подъезд, %d этаж, справа от лифта, влево", flatNumber, entrance, floor);
            default ->
                    String.format("%d кв - %d подъезд, %d этаж, справа от лифта, вправо", flatNumber, entrance, floor);
        };
    }
}
