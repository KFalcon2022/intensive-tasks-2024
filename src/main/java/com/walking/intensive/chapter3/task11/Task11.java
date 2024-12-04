package com.walking.intensive.chapter3.task11;

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
        int[] array = {1, 4, 2, 5, 3};
        System.out.println(getOddSubArraysElementsSum(array));
    }

    static int getOddSubArraysElementsSum(int[] array) {
        if (!isValid(array)) {

            return -1;
        }
        if (array.length == 0) {

            return 0;
        }
        int totalSum = 0;

        for (int i = 0; i < array.length; i++) {

            int sum = 0;

            for (int j = i; j < array.length; j++) {

                sum += (j - i + 1) % 2 != 0 ? getRangeSum(array, i, j) : 0;
            }
            totalSum += sum;
        }
        return totalSum;
    }

    private static int getRangeSum(int[] array, int fromIndex, int toIndex) {

        int sum = 0;

        for (int i = fromIndex; i <= toIndex; i++) {

            sum += array[i];
        }
        return sum;
    }

    private static boolean isValid(int[] array) {

        for (int element : array) {

            if (element < 0) {

                return false;
            }
        }
        return true;
    }
}
