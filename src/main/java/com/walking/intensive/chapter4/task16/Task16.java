package com.walking.intensive.chapter4.task16;

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
//        Для собственных проверок можете делать любые изменения в этом методе
//        int[] arr1 = {2, 3, 4, 5, 4, 10, 22, 2};
//        int[] arr2 = {5, 1};
//        int[] arrnull = {};

//        System.out.println(isEqualSize(arr1, arr2));
//        System.out.println(isEquals(arr1, arr2));
//        System.out.println(Arrays.toString(incrementEach(arr1)));
//        System.out.println(Arrays.toString(multiplyEach(arr1, arr2)));
//        System.out.println(Arrays.toString(subtractEach(arr1, arr2)));
//        System.out.println(Arrays.toString(reverse(arrnull)));
//        System.out.println(Arrays.toString(add(new int[]{10, 11, 12}, 100, 300)));
//        System.out.println(Arrays.toString(add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5, 55)));

//        System.out.println(isContains(arr1, 7));
//        System.out.println(getFirstIndex(arr1, 4));
//        System.out.println(getLastIndex(arr1, 2));
//        System.out.println(Arrays.toString(removeByIndex(arr1, 1)));
//        System.out.println(Arrays.toString(removeAll(arr1, 2, 10, 7, 19, 100)));
//        System.out.println(Arrays.toString(removeAll(new int[]{1, 2, 3, 4, 5}, new int[]{})));
//        System.out.println(isSimilar(new int[]{4, 10, 5, 6, 11, 12, 3, 1, 2}, new int[]{1, 2, 3, 4, 10, 5, 11, 6, 12}));


    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {

        return arr1 != null && arr2 != null && arr1.length == arr2.length && arr1.length > 0;
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

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] + 1;
        }

        return result;
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

        if (arr1.length == 0 && arr2.length == 0) {
            return new int[0];
        }

        int length = Math.max(arr1.length, arr2.length);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int a = i < arr1.length ? arr1[i] : 0;
            int b = i < arr2.length ? arr2[i] : 0;
            result[i] = a * b;
        }
        return result;
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
        if (arr1.length == 0 && arr2.length == 0) {
            return new int[0];
        }

        int length = Math.max(arr1.length, arr2.length);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int a = i < arr1.length ? arr1[i] : 0;
            int b = i < arr2.length ? arr2[i] : 0;
            result[i] = a - b;
        }
        return result;

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
        int length = arr.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = arr[length - 1 - i];
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

        int[] result = new int[arr.length + 1];
        int length = arr.length + (index > arr.length ? 0 : 1);
        for (int i = 0; i < length; i++) {

            if (i == index) {
                result[i] = newValue;
                continue;
            }

            int oldIndex = i - (i >= index ? 1 : 0);
            result[i] = arr[oldIndex];
        }

        if (index >= arr.length) {
            result[result.length - 1] = newValue;
        }
        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {
        for (int i : arr) {

            if (i == value) {
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
        for (int i = 1; i <= arr.length; i++) {

            if (arr[arr.length - i] == value) {
                return arr.length - i;
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

        int length = index > arr.length ? arr.length : arr.length - 1;
        int[] result = new int[length];
        for (int i = 0, j = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }
            result[j++] = arr[i];
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

        int newLength = arr.length;
        boolean[] indexToRemove = new boolean[newLength];
        for (int values : removingValues) {
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == values) {
                    indexToRemove[i] = true;
                    newLength--;
                }
            }
        }

        int[] result = new int[newLength];
        for (int i = 0, index = 0; i < arr.length; i++) {

            if (!indexToRemove[i]) {
                result[index++] = arr[i];
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

        return isExist(arr1, arr2) && isExist(arr2, arr1);
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

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int length = arr.length;
        int[] result = new int[length];
        for (int i = length - 1; i > 0; i--) {
            result[i] = arr[i - 1];
        }
        result[0] = arr[length - 1];
        return result;
    }

    static boolean isExist(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        boolean exist = false;
        for (int val2 : arr2) {
            exist = (isContains(arr1, val2));
        }

        return exist;
    }

}
