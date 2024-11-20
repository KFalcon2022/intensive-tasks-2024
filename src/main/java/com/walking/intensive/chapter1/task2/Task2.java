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

        System.out.println(getFlatLocation(10, 3, 40));
        System.out.println(getFlatLocation(11, 2, 45));
        System.out.println(getFlatLocation(4, 1, 2));
        System.out.println(getFlatLocation(2, 40, 1234));
        System.out.println(getFlatLocation(2, 40, -12));


    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода

        int numberOfApartmentsPerFloor = 4;

        String badResult = "Некорректные входные данные";
        String badResult2 = "Такой квартиры не существует";

        if (flatNumber < 1) {
            return badResult;
        }

        if (flatNumber > numberOfApartmentsPerFloor * entranceAmount * floorAmount) {
            return badResult2;
        }

        // Определяем подъезд
        int determineTheEntrance = (flatNumber - 1) / (floorAmount * numberOfApartmentsPerFloor) + 1;

        // Определяем этаж
        int apartmentNumberRelativeToTheEntrance = (flatNumber - 1) % (floorAmount * numberOfApartmentsPerFloor);
        int floorNumber = apartmentNumberRelativeToTheEntrance / numberOfApartmentsPerFloor + 1;

        // Расположение этажа относительно лифта
        int positionPerFloor = apartmentNumberRelativeToTheEntrance % numberOfApartmentsPerFloor;

        String positionRelativeToTheElevator;

        if (positionPerFloor < 2) {
            positionRelativeToTheElevator = "слева от лифта";
        } else {
            positionRelativeToTheElevator = "справа от лифта";
        }

        String route;

        if (positionPerFloor % 2 == 0) {
            route = "влево";
        } else {
            route = "вправо";
        }

        return flatNumber + " кв" + " - " + determineTheEntrance + " подъезд, " + floorNumber +
                " этаж, " + positionRelativeToTheElevator + ", " + route;

    }
}
