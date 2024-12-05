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

        System.out.println(getFlatLocation(3, 5, 60));


    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //      Проверка на отрицательные числа и 0
        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }


        // Всего квартир в доме
        int totalFlats = floorAmount * entranceAmount * 4;

//Проверяем чтобы квартира не выходила за общий диапазон квартир
        if (flatNumber > totalFlats) {
            return "Такой квартиры не существует";
        }

        String flatSide;
        String sideFromElevator = "слева от лифта";
        int floor = 1;
        int entrance = 1;
        int checkFlatSideFromElevator = 1;

//        Сколько всего квартир в одном подъезде
        int countFlatsInOneEntrance = floorAmount * 4;

        for (int i = 1; i <= totalFlats; i++) {
//            Судя по схеме расположения квартир четные всегда будут справа
            if (i % 2 == 0) {
                flatSide = "вправо";
            } else {
                flatSide = "влево";
            }


            if (i == flatNumber) {
                return i + " кв - " + entrance + " подъезд, " + floor + " этаж, " + sideFromElevator + ", " + flatSide;
            }


//            Находим текущий подъезд и начинаем отсчет этажей заново
            if (i % countFlatsInOneEntrance == 0 && i != totalFlats) {
                entrance++;
                floor = 0;
            }
//Находим текущий этаж, по 4 хаты на этаже
            if (i % 4 == 0) {
                floor++;
            }


            checkFlatSideFromElevator++;

            if (checkFlatSideFromElevator > 2) {
                sideFromElevator = "справа от лифта";
            }
            if (checkFlatSideFromElevator > 4) {
                sideFromElevator = "слева от лифта";
                checkFlatSideFromElevator = 1;
            }

        }


        return null;
    }
}
