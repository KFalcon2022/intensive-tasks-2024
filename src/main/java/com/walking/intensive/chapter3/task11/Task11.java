package com.walking.intensive.chapter3.task11;

import java.util.Arrays;

/**
 * Реализуйте метод getOddSubArraysElementsSum() с учетом условий ниже.
 *
 * <p>Входной параметр метода - массив положительных целых чисел.
 *
 * <p>Возвращаемое значение - сумма элементов всех возможных подмассивов нечетной длины.
 * Подмассивом считается непрерывная последовательность элементов массива.
 *
 * <p>Например:
 *
 * <p>Входные данные: array = [1,4,2,5,3]
 *
 * <p>Подмассивы и суммы их элементов:
 *
 * <ul>
 * <li>[1] = 1
 * <li>[4] = 4
 * <li>[2] = 2
 * <li>[5] = 5
 * <li>[3] = 3
 * <li>[1,4,2] = 7
 * <li>[4,2,5] = 11
 * <li>[2,5,3] = 10
 * <li>[1,4,2,5,3] = 15
 * </ul>
 *
 * <p>Итоговая сумма: 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * <p>Возвращаемое значение: 58
 *
 * <p>Для пустого массива должен возвращаться 0.
 *
 * <p>При наличии любых некорректных данных - например, неположительных элементов входящего массива, метод должен
 * возвращать -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task11 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int[] array = {1, -4, 2, 5, 3};
        System.out.println(getOddSubArraysElementsSum(array));
    }

    static int getOddSubArraysElementsSum(int[] array) {
        for (int i : array) {
            if (i < 0) {
                return -1;
            }
        }

        int finalSum = 0;
        int index = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = index; j < (array.length + 1); j++) {
                int[] tmpArray = Arrays.copyOfRange(array, i, j);
                if (tmpArray.length % 2 != 0) {
                    finalSum = finalSum + getSum(tmpArray);
                }
            }
            index = index + 1;
        }

        return finalSum;
    }

    static int getSum(int[] tmpArray) {
        int sum = 0;

        for (int j : tmpArray) {
            sum = sum + j;
        }

        return sum;
    }
}
