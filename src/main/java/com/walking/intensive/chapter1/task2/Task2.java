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
        Scanner in = new Scanner(System.in);
        int floorAmount = in.nextInt();
        int entranceAmount = in.nextInt();
        int flatNumber = in.nextInt();
        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int flatOnFloor = 4;
        int countAllFlats = flatOnFloor * floorAmount * entranceAmount;
        int countFlatOnEnt = flatOnFloor * floorAmount;

        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            System.out.println("Некорректные входные данные");
        }

        if (countAllFlats >= flatNumber && flatNumber >= 1) {
            int numberOfEnt = flatNumber / (double) countFlatOnEnt % 1 == 0 ? flatNumber / countFlatOnEnt : (flatNumber / countFlatOnEnt) + 1;
            double numberOfFloor = (double) (flatNumber - (countFlatOnEnt * (numberOfEnt - 1))) / flatOnFloor;
            int numberFloor = numberOfFloor % 1 == 0 ? (int) numberOfFloor : (int) (numberOfFloor + 1);
            int sideForSide = (flatNumber - (countFlatOnEnt * (numberOfEnt - 1))) % flatOnFloor;
            String side = sideForSide <= 2 & sideForSide != 0 ? " слева от лифта," : " справа от лифта,";
            String sideOnFloor = flatNumber % 2 == 0 ? " вправо" : " влево";

            return flatNumber + " кв - " + numberOfEnt + " подъезд, " + numberFloor + " этаж," + side + sideOnFloor;
        } else {
            return "Такой квартиры не существует";
        }
    }
}
