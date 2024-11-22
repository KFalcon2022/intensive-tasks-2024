package com.walking.intensive.chapter1.task2;

import java.util.Scanner;

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

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Количество этажей: ");
        int floorAmount = in.nextInt();

        System.out.print("Количество подъездов: ");
        int entranceAmount = in.nextInt();

        System.out.print("Номер нужной квартиры: ");
        int flatNumber = in.nextInt();

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation (int floorAmount, int entranceAmount, int flatNumber) {

        int flatAmount = floorAmount * entranceAmount * 4;
        int flatInEntrance = floorAmount * 4;
        int entranceNumber;
        int floorNumber;

       if (flatNumber <= 0) {
           return "Некорректные входные данные";
       }

        if (flatNumber % flatInEntrance != 0) {
            entranceNumber = flatNumber / flatInEntrance + 1;
        } else {
            entranceNumber = flatNumber / flatInEntrance;
        }

        if (flatNumber % 4 == 0) {
            floorNumber = (flatNumber - (entranceNumber - 1) * flatInEntrance) / 4;
        } else {
            floorNumber = (flatNumber - (entranceNumber - 1) * flatInEntrance) / 4 + 1;
        }

        if (flatNumber > flatAmount) {
            return "Такой квартиры не существует";
        }

        if (flatNumber > 0) {

            switch (flatNumber % 4) {
                case 1:
                    return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, слева от лифта, влево";

                case 2:
                    return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, слева от лифта, вправо";

                case 3:
                    return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, справа от лифта, влево";

            }
        }

        return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, справа от лифта, вправо";

    }
}
