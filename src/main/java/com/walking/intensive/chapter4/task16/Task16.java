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
        System.out.println(isContains(new int[]{1, 2, 3}, 0));
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {
        return arr1 != null && arr2 != null && arr1.length != 0 && arr2.length == arr1.length;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы полностью идентичны по составу.
     * В остальных случаях - false.
     *
     * <p>Идентичными считаются массивы одинаковой длины, для которых arr1[i] == arr2[i] для любого i.
     */
    static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
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
        if (arr == null) {
            return null;
        }

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
        if (arr1 == null || arr2 == null) {
            return null;
        }

        int[] multipliedArray = new int[Math.max(arr1.length, arr2.length)];
        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            multipliedArray[i] = arr1[i] * arr2[i];
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
        if (arr1 == null || arr2 == null) {
            return null;
        }

        int[] subtractedArray = Arrays.copyOf(arr1, Math.max(arr1.length, arr2.length));
        for (int i = 0; i < arr2.length; i++) {
            subtractedArray[i] -= arr2[i];
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
        if (arr == null) {
            return null;
        }

        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - i - 1];
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
        if (arr == null) {
            return null;
        }

        if (index < 0) {
            return new int[0];
        }

        int[] arrayAddition = new int[arr.length + 1];
        for (int i = 0; i < arrayAddition.length; i++) {
            if (i == index || (i == arr.length && index > arr.length)) {
                arrayAddition[i] = newValue;
            } else if (i < index) {
                arrayAddition[i] = arr[i];
            } else {
                arrayAddition[i] = arr[i - 1];
            }
        }

        return arrayAddition;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {
        if (arr == null) {
            return false;
        }

        for (int element : arr) {
            if (element == value) {
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
        if (arr == null) {
            return -1;
        }

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
        if (arr == null) {
            return -1;
        }

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
        if (arr == null) {
            return null;
        }

        if (index < 0) {
            return new int[0];
        }

        if (index >= arr.length) {
            return Arrays.copyOf(arr, arr.length);
        }

        int[] removedIndexArray = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                removedIndexArray[i] = arr[i];
            } else if (i > index) {
                removedIndexArray[i - 1] = arr[i];
            }
        }

        return removedIndexArray;
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
        if (arr == null || removingValues == null) {
            return null;
        }

        int[] removedValuesArray = new int[0];
        for (int element : arr) {
            if (!isContains(removingValues, element)) {
                removedValuesArray = add(removedValuesArray, removedValuesArray.length, element);
            }
        }

        return removedValuesArray;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {
        int[] differenceArray1 = removeAll(arr1, arr2);
        int[] differenceArray2 = removeAll(arr2, arr1);

        return differenceArray1 != null && differenceArray2 != null && differenceArray1.length == 0 &&
                differenceArray2.length == 0;
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
        if (arr == null) {
            return null;
        }

        int[] shiftedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shiftedArray[(i + 1) % arr.length] = arr[i];
        }

        return shiftedArray;
    }
}
