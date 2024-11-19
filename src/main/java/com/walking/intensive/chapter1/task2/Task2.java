package com.walking.intensive.chapter1.task2;

import static java.lang.Math.ceil;

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
        int floorAmount = 10; // кол-во этажей
        int entranceAmount = 3; //кол-во подъездов
        int flatNumber = 88; //номер квартиры

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        double flatAmount = 4; //кол-во квартир на этаже
        String side1;
        String side2;

        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        } else {
            if (flatNumber <= (flatAmount * floorAmount * entranceAmount)) {
                int entranceNumber = (int) Math.ceil((double) flatNumber / flatAmount / floorAmount); //подъезд
                int floorNumber = (int) Math.ceil((double) (flatNumber - (flatAmount * floorAmount * (entranceNumber - 1))) / flatAmount); //этаж
                double angleCoefficient = (flatNumber / flatAmount) - Math.floor(flatNumber / flatAmount);

                if (angleCoefficient != 0 & angleCoefficient <= 0.5) {
                    side1 = "слева от лифта,";
                } else {
                    side1 = "справа от лифта,";
                }

                if (angleCoefficient == 0 || angleCoefficient == 0.5) {
                    side2 = " вправо";
                } else {
                    side2 = " влево";
                }
                return flatNumber + " кв" + " - " + entranceNumber + " подъезд" + "," + " " + floorNumber + " этаж" + ", " + side1 + side2;
            } else {
                return "Такой квартиры не существует";
            }
        }
    }
}