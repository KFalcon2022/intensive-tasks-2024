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
 * Это связано с тем, что в реальных условиях такой входящий массив может далее
 * использоваться в каких-либо иных расчетах и ожидается, что он будет находиться
 * в своем исходном состоянии.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task16 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 4, 5, 6};
        int[] arr2 = {5, 11, 1};

        System.out.println("Одинаковая длина: " + isEqualSize(arr1, arr2)); // ok
        System.out.println("Полностью идентичны: " + isEquals(arr1, arr2)); // ok
        System.out.println("Увеличили на единицу: " + Arrays.toString(incrementEach(arr1))); // ok
        System.out.println("Перемноженный массив: " + Arrays.toString(multiplyEach(arr1, arr2))); // ok
        System.out.println("Массив после вычитания: " + Arrays.toString(subtractEach(arr1, arr2))); // ok
        System.out.println("Массив в реверсивном порядке: " + Arrays.toString(reverse(arr1))); // ok
        System.out.println("После добавления индекса: " + Arrays.toString(add(arr1, 2, 455))); //ok
        System.out.println(("Содержит ли число: " + isContains(arr1, 6))); // ok
        System.out.println(("Минимальный совпадающий индекс: " + getFirstIndex(arr1, 5))); // ok
        System.out.println(("Максимальный совпадающий индекс: " + getLastIndex(arr1, 4))); // ok
        System.out.println("После удаления индекса: " + Arrays.toString(removeByIndex(arr1, 2))); //
        System.out.println("Удалив несколько чисел: " + Arrays.toString(removeAll(arr1, 5, 1))); // ok
        System.out.println("Со смещённым индексом: " + Arrays.toString(shiftIndex(arr1))); // ok
        System.out.println();
        System.out.println(isSimilar(arr1, arr2));
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {
        if (isEmpty(arr1)) {
            return false;
        }

        return arr1.length == arr2.length;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы полностью идентичны по составу.
     * В остальных случаях - false.
     *
     * <p>Идентичными считаются массивы одинаковой длины, для которых arr1[i] == arr2[i] для любого i.
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
     * И возвращает массив, в котором каждый элемент исходного увеличен на единицу.
     *
     * <p>Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60]
     *
     * <p>Возвращаемое значение: [11,21,31,41,51,21,61]
     */
    static int[] incrementEach(int[] arr) {
        int[] incrementedArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            incrementedArray[i] = arr[i] + 1;
        }

        return incrementedArray;
    }

    /**
     * Реализуйте метод, который принимает параметрами два массива целых чисел: arr1 и arr2.
     * И возвращает массив, в котором каждый result[i] - произведение arr1[i] и arr2[i].
     *
     * <p>Если массивы разной длины - недостающие значения более короткого
     * массива необходимо считать как 0.
     *
     * <p>В случае с двумя пустыми массивами необходимо вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,4], [4,5,6]
     *
     * <p>Возвращаемое значение: [8,15,24]
     */
    static int[] multiplyEach(int[] arr1, int[] arr2) {
        int[] smallerArray;
        int[] largerArray;

        if (arr1.length <= arr2.length) {
            smallerArray = Arrays.copyOf(arr1, arr1.length);
            largerArray = Arrays.copyOf(arr2, arr2.length);
        } else {
            smallerArray = Arrays.copyOf(arr2, arr2.length);
            largerArray = Arrays.copyOf(arr1, arr1.length);
        }

        int[] multipliedArray = new int[largerArray.length];

        if (isEmpty(smallerArray)) {
            return multipliedArray;
        }

        for (int i = 0; i < smallerArray.length; i++) {
            multipliedArray[i] = smallerArray[i] * largerArray[i];
        }

        return multipliedArray;
    }

    /**
     * Реализуйте метод, который принимает параметрами два массива целых чисел: arr1 и arr2.
     * И возвращает массив, в котором каждый result[i] - разность arr1[i] и arr2[i].
     *
     * <p>Если массивы разной длины - недостающие значения более короткого
     * массива необходимо считать как 0.
     *
     * <p>В случае с двумя пустыми массивами необходимо вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,6], [4,5,4]
     *
     * <p>Возвращаемое значение: [-2,-2,2]
     */
    static int[] subtractEach(int[] arr1, int[] arr2) {
        if (arr1.length <= arr2.length) {
            arr1 = Arrays.copyOf(arr1, arr2.length);
            for (int i = arr1.length + 1; i < arr2.length; i++) {
                arr1[i] = 0;
            }
        } else {
            arr2 = Arrays.copyOf(arr2, arr1.length);
            for (int i = arr2.length + 1; i < arr1.length; i++) {
                arr2[i] = 0;
            }
        }

        int[] subtractedArray = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            subtractedArray[i] = arr1[i] - arr2[i];
        }

        return subtractedArray;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, развернутый в обратном порядке.
     *
     * <p>Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,4],
     *
     * <p>Возвращаемое значение: [4,3,2]
     */
    static int[] reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }

        return reversedArray;
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

        int[] addedArr = new int[arr.length + 1];

        if (index >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                addedArr[i] = arr[i];
            }

            addedArr[arr.length] = newValue;

        } else {
            for (int i = 0; i < index; i++) {
                addedArr[i] = arr[i];
            }

            addedArr[index] = newValue;

            for (int j = index + 1; j < addedArr.length; j++) {
                addedArr[j] = arr[j - 1];
            }
        }

        return addedArr;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {
        for (int i : arr) {
            if (value == i) {
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
            if (value == arr[i]) {

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

        int[] removedIndex = index < arr.length
                ? new int[arr.length - 1]
                : new int[arr.length];

        if (index >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                removedIndex[i] = arr[i];
            }

            return removedIndex;
        }

        for (int i = 0; i < index; i++) {
            removedIndex[i] = arr[i];
        }

        for (int j = index; j < removedIndex.length; j++) {
            removedIndex[j] = arr[j + 1];
        }

        return removedIndex;
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
        int[] removedAll = Arrays.copyOf(arr, arr.length);

        for (int removingValue : removingValues) {
            for (int i = 0; i < removedAll.length; i++) {
                int index = getFirstIndex(removedAll, removingValue);
                if (index != -1) {
                    removedAll = removeByIndex(removedAll, index);
                }
            }
        }

        return removedAll;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) || isEmpty(arr2)) {
            return false;
        }

        for (int i : arr1) {
            if (!isContains(arr2, i)) {
                return false;
            }
        }

        for (int i : arr2) {
            if (!isContains(arr1, i)) {
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
     * <p> Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,3,4]
     * <p>Возвращаемое значение: [4,1,2,3]
     */
    static int[] shiftIndex(int[] arr) {
        if (isEmpty(arr)) {
            return new int[0];
        }

        int[] shiftedArray = new int[arr.length];
        shiftedArray[0] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            shiftedArray[i] = arr[i - 1];
        }

        return shiftedArray;
    }

    static boolean isEmpty(int[] array) {
        return array.length == 0;
    }
}
