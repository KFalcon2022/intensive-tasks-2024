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
        int entranceAmount = 3;
        int flatNumber = 40;
        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int flatAmount = floorAmount * entranceAmount * 4;
        if (flatAmount < flatNumber) {
            return "Такой квартиры не существует";
        }
        if (floorAmount < 1 || entranceAmount < 1 || flatNumber < 1) {
            return "Некорректные входные данные";
        }
        int entranceNumber = 1 + (flatNumber - 1) / (flatAmount / entranceAmount);
        int floorNumber = 1 + ((flatNumber - 1) % (flatAmount / entranceAmount) / 4);
        String option1 = " этаж, слева от лифта, влево";
        String option2 = " этаж, слева от лифта, вправо";
        String option3 = " этаж, справа от лифта, влево";
        String option4 = " этаж, справа от лифта, вправо";
        return switch (flatNumber % 4) {
            case 1 -> flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + option1;
            case 2 -> flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + option2;
            case 3 -> flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + option3;
            default -> flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + option4;
        };
    }
}
