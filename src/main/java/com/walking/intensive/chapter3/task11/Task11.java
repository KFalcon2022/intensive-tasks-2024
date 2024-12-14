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
//        Для собственных проверок можете делать любые изменения в этом методе
        int[] a = {1, 4, 2, 5, 3};
        System.out.println(getOddSubArraysElementsSum(a));
    }

    static int getOddSubArraysElementsSum(int[] array) {
        // Ваш код
        if (array == null) {
            return 0;
        }

        if (!isArrayValid(array)) {
            return -1;
        }

        int length = array.length;
        int largestOddArray = length % 2 == 0 ? length - 1 : length;
        int oddSubArraysElementsSum = 0;

        for (int i = largestOddArray; i >= 3; i -= 2) {

            for (int j = 0; j <= length - i; j++) {
                oddSubArraysElementsSum += getElementsSum(array, j, j + i - 1);
            }
        }

        oddSubArraysElementsSum += getElementsSum(array, 0, length - 1);
        return oddSubArraysElementsSum;
    }

    static int getElementsSum(int[] array, int firstElement, int lastElement) {
        int elementsSum = 0;

        for (int j = firstElement; j <= lastElement; j++) {
            elementsSum += array[j];
        }

        return elementsSum;
    }

    static boolean isArrayValid(int[] array) {
        for (int number : array) {
            if (number < 0) {
                return false;
            }
        }

        return true;
    }
}
