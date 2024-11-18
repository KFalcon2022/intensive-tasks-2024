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
        int floorAmount = 10;//кол-во этажей
        int entranceAmount = 3;//кол-во подъездов
        int flatNumber = 17;//квартира

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));

    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int flatExists = (floorAmount * 4) * entranceAmount;//условие что квартира существует

        int allApartmentsPerEntrance = floorAmount * 4; //всего квартир в подъезде

        int entranceNumber = (flatNumber - 1) / allApartmentsPerEntrance + 1; //в каком подъезде квартира

        int flatInEntrance = (flatNumber - 1) % allApartmentsPerEntrance + 1; //номер квартиры в подъезде

        int floorNumber = (flatNumber - 1) / 4 + 1;// какой этаж

        int apartmentFloor = (flatInEntrance - 1) % 4 + 1; //номер квартиры на этаже



        if (apartmentFloor == 1 && entranceAmount >= 1 && floorAmount >= 1) {
            return flatNumber + " кв" + " - " + entranceNumber + " подъезд, " + floorNumber + " этаж, слева от лифта, влево";
        } else if (apartmentFloor == 2 && entranceAmount >= 1 && floorAmount >= 1) {
            return flatNumber + " кв" + " - " + entranceNumber + " подъезд, " + floorNumber + " этаж, слева от лифта, вправо";
        } else if (apartmentFloor == 3 && entranceAmount >= 1 && floorAmount >= 1) {
            return flatNumber + " кв" + " - " + entranceNumber + " подъезд, " + floorNumber + " этаж, справа от лифта, влево";
        } else if (apartmentFloor == 4 && entranceAmount >= 1 && floorAmount >= 1) {
            return flatNumber + " кв" + " - " + entranceNumber + " подъезд, " + floorNumber + " этаж, справа от лифта, вправо";
        } else if (flatNumber > flatExists && entranceAmount >= 1 && floorAmount >= 1 || flatNumber <= 0) {
            return "Такой квартиры не существует";
        } else {// flatNumber<=0 || entranceAmount<=0 || floorAmount<=0
            return "Некорректные входные данные";
        }

    }
}
