package com.walking.intensive.chapter4.task16;

import java.util.Arrays;

/**
 * После завершения интенсива вы достаточно быстро познакомитесь с Java Collection Framework.
 * Это знакомство позволит сильно упростить работу с массивами данных.
 *
 * <p>Но пока этого не произошло - даже типовые операции приходится производить вручную.
 * Эта задача - наглядная тому демонстрация.
 *
 * <p>Удачи!
 *
 * <p>P.S. Обратите внимание: если в методе требуется как-то изменять
 * содержимое массива - метод всегда должен возвращать новый массив.
 * Массивы, передаваемые в параметрах, изменяться не должны.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task16 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int[] arr = {10,11,12,1,2,3};
        System.out.println(Arrays.toString(shiftIndex(arr)));

        int[] arr1 = {1,2,3,4,6,7};
        System.out.println(Arrays.toString(removeAll(arr1, 1, 2, 3, 4, 5, 6, 7)));
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {

        return arr1.length > 0 && arr1.length == arr2.length;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы полностью идентичны по составу.
     * В остальных случаях - false.
     */
    static boolean isEquals(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, в котором каждый элемент исходного увеличен на единицу
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60]
     *
     * <p>Возвращаемое значение: [11,21,31,41,51,21,61]
     */
    static int[] incrementEach(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i]+=arr[i]+1;
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами два массива целых чисел: arr1 и arr2.
     * И возвращает массив, в котором каждый result[i] - произведение arr1[i] и arr2[i].
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,4], [4,5,6]
     *
     * <p>Возвращаемое значение: [8,15,24]
     */
    static int[] multiplyEach(int[] arr1, int[] arr2) {

        int length = arr1.length;

        if (length == 0) {
            return arr2;
        }

        if (arr2.length == 0) {
            return arr1;
        }

        if (length != arr2.length) {
            return new int[0];
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = arr1[i] * arr2[i];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами два массива целых чисел: arr1 и arr2.
     * И возвращает массив, в котором каждый result[i] - разность arr1[i] и arr2[i].
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,6], [4,5,4]
     *
     * <p>Возвращаемое значение: [-2,-2,2]
     */
    static int[] subtractEach(int[] arr1, int[] arr2) {

        int length = arr1.length;

        if (length == 0) {
            return arr2;
        }

        if (arr2.length == 0) {
            return arr1;
        }

        if (length != arr2.length) {
            return new int[0];
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = arr1[i] - arr2[i];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, развернутый в обратном порядке.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,4],
     *
     * <p>Возвращаемое значение: [4,3,2]
     */
    static int[] reverse(int[] arr) {

        int length = arr.length;

        if (length <= 1) {
            return arr;
        }

        int[] result = new int[length];

        for (int i = 0, j = length - 1; i < length; i++, j--) {
            result[i] = arr[j];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел, индекс массива и целое число.
     * И возвращает массив, в котором число вставлено по указанному индексу в исходный массив.
     * Остальные элементы массива должны быть сдвинуты вправо.
     *
     * <p>Если индекс превышает длину массива - число добавляется в конец массива.
     * Если индекс некорректный (например, отрицательный), метод должен вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,3,4], 2, 456
     *
     * <p>Возвращаемое значение: [1,2,456,3,4]
     */
    static int[] add(int[] arr, int index, int newValue) {

        if (index < 0) {
            return new int[0];
        }

        int length = arr.length;

        int[] result = new int[length + 1];

        if (index > length) {
            index = length;
        }

        for (int i = 0, j = 0; i <= length; i++) {

            if (i == index) {
                result[i] = newValue;
            } else {
                result[i] = arr[j++];
            }
        }

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {

        for (int x : arr) {

            if (x == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и искомое целое число.
     * И возвращает минимальный индекс, на котором найдет данное число в массиве.
     *
     * <p>Если в массиве нет искомого элемента - метод должен вернуть -1.
     *
     * <p>Пример 1:
     *
     * <ul>
     * <li>Входные данные: [10,20,30,40,50,20,60], 20
     * <li>Возвращаемое значение: 1
     * </ul>
     *
     * <p>Пример 2:
     *
     * <ul>
     * <li>Входные данные: [10,30,40,50,60], 20
     * <li>Возвращаемое значение: -1
     * </ul>
     */
    static int getFirstIndex(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и искомое целое число.
     * И возвращает максимальный индекс, на котором найдет данное число в массиве.
     *
     * <p>Если в массиве нет искомого элемента - метод должен вернуть -1.
     *
     * <p>Пример 1:
     *
     * <ul>
     * <li>Входные данные: [10,20,30,40,50,20,60], 20
     * <li>Возвращаемое значение: 5
     * </ul>
     *
     * <p>Пример 2:
     *
     * <ul>
     * <li>Входные данные: [10,30,40,50,60], 20
     * <li>Возвращаемое значение: -1
     * </ul>
     */
    static int getLastIndex(int[] arr, int value) {

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и целое число - индекс.
     * И возвращает массив без значения по указанному индексу. Другие значения должны быть сдвинуты влево.
     *
     * <p>Если указанный индекс выходит за пределы массива - метод должен вернуть копию исходного массива.
     * Если индекс некорректный - метод должен вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60], 2
     * <p>Возвращаемое значение: [10,20,40,50,20,60]
     */
    static int[] removeByIndex(int[] arr, int index) {

        if (index < 0) {
            return new int[0];
        }

        int length = arr.length;

        if (index >= length) {

            int[] copyArray = new int[length];

            for (int i = 0; i < length; i++) {
                copyArray[i] = arr[i];
            }

            return copyArray;
        }

        int[] result = new int[length - 1];

        for (int i = 0, j = 0; i < length; i++) {

            if (i != index) {
                result[j++] = arr[i];
            }
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и
     * еще один массив целых чисел (в виде varargs).
     * И возвращает первый массив, удалив из него все числа, которые есть во втором.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60], [20,23,30]
     * <p>Возвращаемое значение: [10,40,50,60]
     */
    static int[] removeAll(int[] arr, int... removingValues) {

        if (arr.length == 0 || removingValues.length == 0) {
            return arr;
        }

        int resultArrayLength = arr.length;
        boolean[] removedNumbers = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (isContains(removingValues, arr[i])) {
                removedNumbers[i] = true;
                resultArrayLength--;
            }
        }

        if (resultArrayLength == 0) {
            return new int[0];
        }

        int[] result = new int[resultArrayLength];

        for (int i = 0, j = 0; i < arr.length; i++) {

            if (!removedNumbers[i]) {
                result[j++] = arr[i];
            }
        }

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {

        boolean[] commonNumbersArray1 = new boolean[arr1.length];
        boolean[] commonNumbersArray2 = new boolean[arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {
                    commonNumbersArray1[i] = true;
                    commonNumbersArray2[j] = true;
                }
            }
        }

        for (boolean b : commonNumbersArray1) {

            if (!b) {
                return false;
            }
        }

        for (boolean b : commonNumbersArray2) {

            if (!b) {
                return false;
            }
        }

        return true;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, сдвинув все элементы входящего массива на следующий индекс.
     * При этом последний элемент будет перенесен на нулевой индекс.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,3,4]
     * <p>Возвращаемое значение: [4,1,2,3]
     */
    static int[] shiftIndex(int[] arr) {

        int length = arr.length;

        if (length < 2) {
            return arr;
        }

        int [] result = new int[length];
        result[0] = arr[length-1];

        for (int i = 1; i < length; i++) {
            result[i] = arr[i - 1];
        }

        return result;
    }
}
