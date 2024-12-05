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
//        System.out.println(getFlatLocation(2,3,1));
//        System.out.println(getFlatLocation(2,3,2));
//        System.out.println(getFlatLocation(2,3,3));
//        System.out.println(getFlatLocation(2,3,4));
//        System.out.println(getFlatLocation(2,3,5));
//        System.out.println(getFlatLocation(2,3,6));
//        System.out.println(getFlatLocation(2,3,7));
//        System.out.println(getFlatLocation(2,3,8));
//        System.out.println(getFlatLocation(2,3,9));
//        System.out.println(getFlatLocation(2,3,10));
//        System.out.println(getFlatLocation(2,3,11));
//        System.out.println(getFlatLocation(2,3,12));
//        System.out.println(getFlatLocation(2,3,13));
//        System.out.println(getFlatLocation(2,3,14));
//        System.out.println(getFlatLocation(2,3,15));
//        System.out.println(getFlatLocation(2,3,16));
//        System.out.println(getFlatLocation(2,3,17));
//        System.out.println(getFlatLocation(2,3,18));
//        System.out.println(getFlatLocation(2,3,19));
//        System.out.println(getFlatLocation(2,3,20));
//        System.out.println(getFlatLocation(2,3,21));
//        System.out.println(getFlatLocation(2,3,22));
//        System.out.println(getFlatLocation(2,3,23));
//        System.out.println(getFlatLocation(2,3,24));

    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода
        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return ("Некорректные входные данные");
        }

        int maxRoomNbr = floorAmount * entranceAmount * 4;

        if (flatNumber > maxRoomNbr) {
            return ("Такой квартиры не существует");
        }

        int currentFloor = 0;
        int currentEntrance = 0;
        int currentFlatNbr = flatNumber - 1;
        int flatsInEntrance = floorAmount * 4;

        currentEntrance = currentFlatNbr / flatsInEntrance + 1;
        currentFloor = (currentFlatNbr % flatsInEntrance) / 4 + 1;

        int position = currentEntrance * currentFloor * 4 - flatNumber;
        String direction = "";
        int remaind = flatNumber % 4;

        if (remaind == 0) {
            remaind = 4;
        }

        if (flatNumber == 1 || remaind == 1) {
            direction = " слева от лифта, влево";
        } else if (flatNumber == 2 || remaind == 2) {
            direction = " слева от лифта, вправо";
        } else if (flatNumber == 3 || remaind == 3) {
            direction = " справа от лифта, влево";
        } else if (flatNumber == 4 || remaind == 4) {
            direction = " справа от лифта, вправо";
        }

        return (flatNumber + " кв – " + currentEntrance + " подъезд, " + currentFloor + " этаж," + direction);
    }
}
