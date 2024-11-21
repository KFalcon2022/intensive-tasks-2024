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
        int flatNumber = 5;
        int entranceAmount = 4;
        int floorAmount = 5;

        System.out.println(getFlatLocation(floorAmount,entranceAmount,flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int x = 4; // количество квартир на этаже
        int num = (floorAmount * x); // количество квартир в одном подъезде
        int flatLimit = entranceAmount * num; // максимальное количество квартир в доме

        if (flatNumber > flatLimit) {
            return "Такой квартиры нет в этом доме";
        }

        for (int k = 1; k <= entranceAmount; k++) {
            if (flatNumber > 0 && flatNumber <= num * k) {
                System.out.print(k + " подъезд, ");
                //k++;
                break;
            }

        }
        if (flatNumber % num == 0) {
            System.out.print(floorAmount + " этаж, ");

        } else if (flatNumber % num % x != 0 ) {
            System.out.print((flatNumber % num / x + 1) + " этаж, ");
        } else {
            System.out.print((flatNumber % num / x) + " этаж, ");
        }


        switch (flatNumber % 4) {
            case 1:
                System.out.println("слева, влево");
                break;
            case 2:
                System.out.println("слева, вправо");
                break;
            case 3:
                System.out.println("справа, влево");
                break;
            case 0:
                System.out.println("справа, вправо");
                break;

        }
        return "";
    }
}
