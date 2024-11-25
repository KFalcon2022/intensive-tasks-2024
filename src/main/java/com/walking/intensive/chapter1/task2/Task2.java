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
        int entranceAmount = -3;
        int flatNumber = -41;

        if (floorAmount < 1 || entranceAmount < 1 || flatNumber < 1) {
            System.out.println("Некорректные входные данные");
        } else if (floorAmount * entranceAmount * 4 < flatNumber) {
            System.out.println("Такой квартиры не существует");
        } else {
            System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
        }
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int flatAmountInOneEntrance = floorAmount * 4;
        int entranceNumber;
        int floorNumber;
        String str = null;

        if (flatNumber % flatAmountInOneEntrance == 0) {
            entranceNumber = flatNumber / flatAmountInOneEntrance;
        } else {
            entranceNumber = 1 + flatNumber / flatAmountInOneEntrance;
        }

        if (flatAmountInOneEntrance <= flatNumber) {
            if (flatNumber % flatAmountInOneEntrance == 0) {
                floorNumber = floorAmount;
            } else {
                floorNumber = 1 + ((flatNumber / flatAmountInOneEntrance) / 2);
            }
        } else {
            floorNumber = flatNumber / 4 + 1;
        }

        if (flatNumber < 11 || floorNumber / 3 <= 2 && (flatNumber / 20) == ((flatNumber + 9) / 20)) {
            if (flatNumber % 10 == 1 || flatNumber % 10 == 5 || flatNumber % 10 == 9) {
                str = "слева от лифта, влево";
            }
            if (flatNumber % 10 == 2 || flatNumber % 10 == 6 || flatNumber % 10 == 0) {
                str = "слева от лифта, вправо";
            }
            if (flatNumber % 10 == 3 || flatNumber % 10 == 7) {
                str = "справа от лифта, влево";
            }
            if (flatNumber % 10 == 4 || flatNumber % 10 == 8) {
                str = "справа от лифта, вправо";
            }
        } else {
            if (flatNumber % 10 == 1 || flatNumber % 10 == 5 || flatNumber % 10 == 9) {
                str = "справа от лифта, влево";
            }
            if (flatNumber % 10 == 2 || flatNumber % 10 == 6 || flatNumber % 10 == 0) {
                str = "справа от лифта, вправо";
            }
            if (flatNumber % 10 == 3 || flatNumber % 10 == 7) {
                str = "слева от лифта, влево";
            }
            if (flatNumber % 10 == 4 || flatNumber % 10 == 8) {
                str = "слева от лифта, вправо";
            }
        }
        return "%d кв - %d подъезд, %d этаж, %s".formatted(flatNumber, entranceNumber, floorNumber, str);
    }
}
