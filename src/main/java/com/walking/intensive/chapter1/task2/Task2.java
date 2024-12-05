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
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int flatOnFloor = 4;
        int floorTotal = flatNumber / flatOnFloor;
        int floorCounter;
        int flatPlace = floorTotal / floorAmount;
        int entranceCounter = 1;

        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }
        if (flatNumber > floorAmount * flatOnFloor * entranceAmount) {
            return "Такой квартиры не существует";
        }
        if ((flatPlace >= 1) && (flatNumber % (flatOnFloor * floorAmount) != 0)) {
            entranceCounter = flatPlace + 1; //2+подъезд,
        } else if ((flatPlace >= 1) && (flatNumber % (flatOnFloor * floorAmount) == 0)) {
            entranceCounter = flatPlace; //последняя квартира каждого подъезда
        } else if ((flatPlace < 1)) {
            entranceCounter = flatPlace + 1; //1-й подъезд, кроме последней квартиры
        }
        if (flatNumber % flatOnFloor != 0) {
            floorCounter = floorAmount - (floorAmount * entranceCounter - floorTotal) + 1;
        } else
            floorCounter = floorAmount - (floorAmount * entranceCounter - floorTotal);
        if (flatNumber % flatOnFloor == 1 || flatNumber % flatOnFloor == 2) {
            if (flatNumber % flatOnFloor == 1) {
                return flatNumber + " кв - " + entranceCounter + " подъезд, " + floorCounter + " этаж, " + "слева от лифта, влево";
            }
            return flatNumber + " кв - " + entranceCounter + " подъезд, " + floorCounter + " этаж, " + "слева от лифта, вправо";
        } else if (flatNumber % flatOnFloor == 3) {
            return flatNumber + " кв - " + entranceCounter + " подъезд, " + floorCounter + " этаж, " + "справа от лифта, влево";
        }
        return flatNumber + " кв - " + entranceCounter + " подъезд, " + floorCounter + " этаж, " + "справа от лифта, вправо";
    }
}