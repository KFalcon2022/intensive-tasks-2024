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
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int numberFlatInHouse = 4;
        int entranceNumber;

        if (flatNumber <= 0 || floorAmount <= 0 || entranceAmount <= 0) {
            return "Некорректные входные данные";
        }
        if (flatNumber > (floorAmount * entranceAmount * numberFlatInHouse)) { // валидация
            return "Такой квартиры не существует";
        }

        entranceNumber = flatNumber / (floorAmount * numberFlatInHouse);
        if (flatNumber % (floorAmount * numberFlatInHouse) > 0) {
            entranceNumber++;
        }

        int numberFloor;

        if (entranceNumber > 1) {
            numberFloor = (flatNumber / numberFlatInHouse) - ((entranceNumber - 1) * floorAmount);
            if ((double) flatNumber % numberFlatInHouse > 0) {
                numberFloor++;
            }
        } else {
            numberFloor = flatNumber / numberFlatInHouse;
            if ((double) flatNumber % numberFlatInHouse > 0) {
                numberFloor++;
            }
        }

        switch (flatNumber % numberFlatInHouse) {
            case 1:
                return flatNumber + " кв – " + entranceNumber + " подъезд, "
                        + numberFloor + " этаж, слева от лифта, влево";
            case 2:
                return flatNumber + " кв – " + entranceNumber + " подъезд, "
                        + numberFloor + " этаж, слева от лифта, вправо";
            case 3:
                return flatNumber + " кв – " + entranceNumber + " подъезд, "
                        + numberFloor + " этаж, справа от лифта, влево";
            default:
                return flatNumber + " кв – " + entranceNumber + " подъезд, "
                        + numberFloor + " этаж, справа от лифта, вправо";
        }
    }
}

