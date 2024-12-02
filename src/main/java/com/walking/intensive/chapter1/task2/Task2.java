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
        System.out.println(getFlatLocation(9, 3, 108));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода

        int flatAmount = 4 * floorAmount * entranceAmount; // Количество квартир
        if ((flatNumber > flatAmount) || (flatNumber < 1)) {
            return("Nekorreknie vkhodnie dannie");
        }
        else {
            int floorNumber; // Проверка на первый этаж первого подъезда
            if (flatNumber < 5) {
                floorNumber = 1;
            }
            else {
                floorNumber = flatNumber / 4;
            }

            int flatLocationInt = flatNumber % 4;

            String flatLocationString = switch (flatLocationInt) {
                case 1:
                    yield "sleva ot lifta, vlevo";
                case 2:
                    yield "sleva ot lifta, vpravo";
                case 3:
                    yield "sprava ot lifta, vlevo";
                case 0:
                    yield "sprava ot lifta, vpravo";
                default:
                    yield"";
            };

            int entranceNumber = 1;

            while (floorNumber > floorAmount) {
                floorNumber -= floorAmount;
                entranceNumber += 1;
            }

            return(flatNumber + " kv - " + entranceNumber + " pod''ezd, " + floorNumber + " etazh, " + flatLocationString);
        }
    }
}