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
        String result = getFlatLocation(2, 2, 9);
        System.out.println(result);
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int countOfFlats = floorAmount * 4 * entranceAmount;
        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        } else if (flatNumber > countOfFlats) {
            return "Такой квартиры не существует";
        }

        int countOfFlatsInEntrance = countOfFlats / entranceAmount;
        int entrance = getEntrance(flatNumber, entranceAmount, countOfFlatsInEntrance);
        int floor = getFloor(flatNumber, countOfFlatsInEntrance);
        String direction = getDirection(flatNumber, countOfFlatsInEntrance);

        return flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, " + direction;
    }

    private static int getEntrance(int flatNumber, int entranceAmount, int countOfFlatsInEntrance) {
        int entrance = 1;
        while (entrance <= entranceAmount) {
            if (flatNumber <= countOfFlatsInEntrance) {
                break;
            } else {
                entrance++;
                if (flatNumber <= countOfFlatsInEntrance * entrance) {
                    break;
                }
            }
        }
        return entrance;
    }

    private static int getFloor(int flatNumber, int countOfFlatsInEntrance) {
        int floor = 1;
        if (flatNumber < countOfFlatsInEntrance) {
            if (flatNumber % 2 == 0) {
                floor = flatNumber / 4;
            } else {
                floor += flatNumber / 4;
            }
        } else if (flatNumber == countOfFlatsInEntrance) {
            floor = flatNumber / 4;
        } else {
            int numberOfFlatInEntrance = (flatNumber - ((flatNumber / countOfFlatsInEntrance)) * countOfFlatsInEntrance);
            if (numberOfFlatInEntrance < countOfFlatsInEntrance) {
                if (flatNumber % 2 == 0) {
                    floor = numberOfFlatInEntrance / 4;
                } else {
                    floor += numberOfFlatInEntrance / 4;
                }
            } else if (numberOfFlatInEntrance == countOfFlatsInEntrance) {
                floor = numberOfFlatInEntrance / 4;
            }
        }
        return floor;
    }

    private static String getDirection(int flatNumber, int countOfFlatsInEntrance) {
        String leftOfElevator = "слева от лифта";
        String rightOfElevator = "справа от лифта";
        String left = "влево";
        String right = "вправо";

        int direction;
        if (flatNumber <= countOfFlatsInEntrance) {
            direction = flatNumber % 4;
        } else {
            direction = (flatNumber - ((flatNumber / countOfFlatsInEntrance)) * countOfFlatsInEntrance) % 4;
        }

        return switch (direction) {
            case 0 -> rightOfElevator + ", " + right;
            case 1 -> leftOfElevator + ", " + left;
            case 2 -> leftOfElevator + ", " + right;
            case 3 -> rightOfElevator + ", " + left;
            default -> throw new IllegalStateException("Некорректные входные данные");
        };
    }
}