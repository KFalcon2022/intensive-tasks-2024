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
@SuppressWarnings("checkstyle:WhitespaceAround")
public class Task2 {
    public static void main(String[] args) {
        /*getFlatLocation(10,-3,41);*/
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getFlatLocation(10,3,40));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода
        if (flatNumber <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }
        if (floorAmount * entranceAmount * 4 < flatNumber) {
            return "Такой квартиры не существует";
        }
        int maxFlat = floorAmount * entranceAmount * 4; //всего квартир
        int oneEnterance = maxFlat / entranceAmount; //квартир в одном подьезде
        int numberEnterance = flatNumber / oneEnterance; //подьезд
        if (flatNumber % oneEnterance > 0) {
            numberEnterance = numberEnterance + 1;
        }
        int level = (flatNumber / 4);
        if ((flatNumber % 4) > 0) {
            level = ++level;
        }
        if (level > floorAmount) {
            level = level % 10;
        }
        String s =  maxFlat + "всего квартир" + oneEnterance + "квартир в одном подьезде" + numberEnterance + "подьезд";
        return s + "\n Этаж" + level;

    }
}
    /*

        if (age > 10 && age < 15) {
            return "Вам "+ age +" лет";
        }
        if (age > 110 && age < 115) {
            return "Вам "+ age +" лет";
        }
        int lastNum = age % 10;
        switch (lastNum) {
            case 0:
                return "Вам "+ age +" лет";
            case 1:
                return "Вам "+ age +" год";
            case 2:
                return "Вам "+ age +" года";
            case 3:
                return "Вам "+ age +" года";
            case 4:
                return "Вам "+ age +" года";
            default:
                return "Вам "+ age +" лет";
        return null; // Заглушка. При реализации - удалить
    }*/

