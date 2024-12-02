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
        int[] array = {1, 4, 2, 5};
        int result = getOddSubArraysElementsSum(array);
        System.out.println("Сумма подмассивов нечетной длины: " + result);
    }

    static int getOddSubArraysElementsSum(int[] array) {

        int totalSum = 0;

        Integer x = getInteger(array);
        if (x != null) return x;

        // Проверка на наличие положительных целых чисел
        for (int num : array) {
            if (num <= 0) {
                return -1; // Если есть некорректные данные
            }
        }

        // Проходим по всем возможным начальным индексам
        for (int i = 0; i < array.length; i++) {
            // Проходим по всем возможным конечным индексам
            for (int end = i; end < array.length; end++) {
                // Вычисляем длину подмассива
                int length = end - i + 1;

                // Если длина нечетная
                if (length % 2 != 0) {
                    int subArraySum = 0;

                    // Считаем сумму элементов
                    for (int j = i; j <= end; j++) {
                        subArraySum += array[j];
                    }

                    // Прибавляем к общей сумме
                    totalSum += subArraySum;
                }
            }
        }
        return totalSum;
    }

    private static Integer getInteger(int[] array) {
        // Проверка на пустой массив
        if (array == null || array.length == 0) {
            return 0;
        }
        return null;
    }
}
