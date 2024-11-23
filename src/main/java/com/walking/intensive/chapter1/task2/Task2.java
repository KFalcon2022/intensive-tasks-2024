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
public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.print("Введите количество этажей: ");
        int floorAmount = in.nextInt();
        System.out.print("Введите количество подъездов: ");
        int entranceAmount = in.nextInt();
        System.out.print("Введите номер нужной квартиры: ");
        int flatNumber = in.nextInt();

        //int floorAmount = 5, entranceAmount = 5, flatNumber = 41;
        System.out.println(getFlatLocation (floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        final int flatInFlours = 4;

        if (floorAmount > 0 && entranceAmount > 0 && flatNumber > 0) {
            if (floorAmount * entranceAmount * flatInFlours < flatNumber) {
                return "Такой квартиры не существует";
            } else {
                int entrance = 0;
                int floor = 0;
                int route;

                // определение номера подъезда
                for (int i = 1; i <= entranceAmount; i++) {
                    if (i * floorAmount * flatInFlours >= flatNumber) {
                        entrance = i;
                        break;
                    }
                }

                // определение этажа
                for (int i = 1; i <= floorAmount; i++) { // первый подъезд
                    if (((entrance - 1) * floorAmount + i) * flatInFlours >= flatNumber) {
                        floor = i;
                        break;
                    }
                }

                //определение местоположения квартиры на этаже и отправка результата
                route = flatNumber % flatInFlours;
                return flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " +
                        switch (route) {
                            case 1 -> "слева от лифта, влево";
                            case 2 -> "слева от лифта, вправо";
                            case 3 -> "справа от лифта, влево";
                            case 0 -> "справа от лифта, вправо";
                            default -> "ошибка";
                        };
            }
        }
        else {
            return "Некорректные входные данные";
        }

    }
}
