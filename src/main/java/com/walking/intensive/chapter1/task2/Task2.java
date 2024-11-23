
package com.walking.intensive.chapter1.task2;

//import static sun.security.krb5.Confounder.intValue;

import com.sun.source.util.SourcePositions;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>димо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 *
 * <p>Необхо
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
                System.out.println(getFlatLocation(2, 20, 3));

            }

            static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
                //        Место для вашего кода

                double doublefloorAmount = floorAmount;
                double doubleFlutNumber = flatNumber;
                double podesd = 0; //номер подъезда
                double flat = 0; //этаж
                double floorstartpodezd = 0;
                double firstNumberFloor = 0;
                double delta = 0;
                String rasp ="";
                // определим подъезд
                podesd = Math.ceil((doubleFlutNumber /4)/doublefloorAmount);
                if (podesd > entranceAmount) {
                    return "Некорректные входные данные (подъездов не хватило)";
                }
                // определим с какой квартиры начинается наш подъезд
                floorstartpodezd = (4 * doublefloorAmount)*(podesd-1) + 1;
                // определим этаж, где находится квартира
                flat = Math.ceil(doubleFlutNumber / 4 - floorAmount* (podesd - 1));
                // первая квартира на этаже
                firstNumberFloor = (floorstartpodezd +  (flat - 1)*4);
                delta = doubleFlutNumber - firstNumberFloor;
                switch ((int) delta) {
                    case (0):
                        rasp = "слева от лифта, влево";
                        break;
                    case (1):
                        rasp = "слева от лифта, вправо";
                        break;
                    case (2):
                        rasp = "справа от лифта, влево";
                        break;
                    case (3):
                        rasp = "справа от лифта, вправо";
                        break;
                    default:
                        rasp = "Что то не так, проверить вычисления";
                        break;
                }
                return flatNumber + " кв - " + (int) podesd + " подъезд, " + (int) flat + " этаж, " + rasp;

    }
}
