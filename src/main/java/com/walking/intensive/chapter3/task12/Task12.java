package com.walking.intensive.chapter3.task12;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Девочка Света очень любит играть в мячики. Она поставила в ряд корзинки и в некоторые положила по 1 мячику.
 * За 1 раз она может переложить 1 мячик в соседнюю корзинку. В 1 корзинке может поместиться много мячиков.
 *
 * <p>Необходимо помочь Свете. Реализуйте метод getMovementsNumber() с учетом условий ниже.
 *
 * <p>Входной параметр - строка, в которой закодировано положение мячиков в корзинках.
 *
 * <p>Например: "010" - всего есть три корзинки, мячик лежит только во второй.
 *
 * <p>Возвращаемое значение - массив, по размеру идентичный размеру входящей строки,
 * где arr[i] - минимальное количество операций, необходимых для перемещения всех мячиков в i-ю корзинку.
 *
 * <p> Количество необходимых операций для каждой из корзинок необходимо
 * вычислять исходя из начального расположения мячиков в корзинках.
 *
 * <p>Пример:
 *
 * <p>Входящая строка: "110"
 *
 * <p>Возвращаемое значение: [1,1,3]
 *
 * <p>Пояснение:
 *
 * <ul>
 * <li>Корзинка 1 (0-й индекс массива): требуется переложить 1 мячик из второй корзинки 1 раз.
 * <li>Корзинка 2 (1-й индекс массива): требуется переложить 1 мячик из первой корзинки во вторую 1 раз.
 * <li>Корзинка 3 (2-й индекс массива): требуется переложить 1 мячик из первой корзинки во вторую 1 раз,
 *      из второй корзинки переложить в третью 2 мячика по 1 разу, итого 3 раза.
 * </ul>
 *
 * <p>При наличии некорректных входных данных верните пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task12 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMovementsNumber("110")));
    }

    static int[] getMovementsNumber(String baskets) {
        if (!isValidString(baskets)) {
            return new int[]{};
        }

        int basketsAmount = baskets.length();
        int[] totalSteps = new int[basketsAmount];

        for (int i = 0; i < basketsAmount; i++) {
            int steps = 0;
            for (int e = 0; e < basketsAmount; e++) {

                if (baskets.charAt(e) == '1') {
                    steps += Math.abs(e - i);
                }
            }
            totalSteps[i] = steps;
        }

        return totalSteps;
    }

    static boolean isValidString(String baskets) {
        if (baskets == null || baskets.isEmpty()) {
            return false;
        }

        for (int i = 0; i < baskets.length(); i++) {
            if (baskets.charAt(i) != '1' && baskets.charAt(i) != '0') {
                return false;
            }
        }

        return true;
    }
}
