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
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {
        return arr1.length != 0 && arr1.length == arr2.length;
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

        for (int i = 0; i < arr1.length; ++i) {
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
        if (arr.length == 0) {
            return new int[0];
        }

        int[] incrementArray = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            incrementArray[i] = arr[i] + 1;
        }

        return incrementArray;
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

        int[] multiplyArray = new int[Math.max(arr1.length, arr2.length)];
        int minArrayLength = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < minArrayLength; ++i) {
            multiplyArray[i] = arr1[i] * arr2[i];
        }

        return multiplyArray;
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

        int[] subtractArray = new int[Math.max(arr1.length, arr2.length)];
        int minArrayLength = Math.min(arr1.length, arr2.length);
        int i = 0;
        for (; i < minArrayLength; ++i) {
            subtractArray[i] = arr1[i] - arr2[i];
        }

        if (arr1.length < arr2.length) {
            for (; i < subtractArray.length; ++i) {
                subtractArray[i] = -arr2[i];
            }
        } else if (arr1.length > arr2.length) {
            for (; i < subtractArray.length; ++i) {
                subtractArray[i] = arr1[i];
            }
        }

        return subtractArray;
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
        if (arr.length == 0) {
            return new int[0];
        }

        int[] reverseArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArray[i] = arr[arr.length - 1 - i];
        }

        return reverseArray;
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
        if (arr.length == 0 || index < 0) {
            return new int[0];
        }

        int[] addArray = new int[arr.length + 1]; //new int[arr.length];
        if (index >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                addArray[i] = arr[i];
            }
            addArray[arr.length] = newValue;
        } else {
            int i = 0;
            while (i < index) {
                addArray[i] = arr[i];
                ++i;
            }
            addArray[index] = newValue;
            ++i;
            for (; i < addArray.length; i++) {
                addArray[i] = arr[i - 1];
            }
        }

        return addArray;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
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
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                lastIndex = i;
            }
        }

        return lastIndex;
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

        int[] reducedArray;
        if (index >= arr.length) {
            reducedArray = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                reducedArray[i] = arr[i];
            }
        } else {
            reducedArray = new int[arr.length - 1];
            for (int i = 0; i < index; i++) {
                reducedArray[i] = arr[i];
            }
            for (int i = index; i < reducedArray.length; i++) {
                reducedArray[i] = arr[i + 1];
            }
        }

        return reducedArray;
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
        if (arr.length == 0) {
            return new int[0];
        }

        if (removingValues.length == 0) {
            return arr;
        }

        int[] removedArray = new int[arr.length];
        int reducedArrLength = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (getFirstIndex(removingValues, arr[i]) == -1) {
                removedArray[j] = arr[i];
                ++j;
                ++reducedArrLength;
            }
        }

        int[] reducedArray = new int[reducedArrLength];
        for (int i = 0; i < reducedArrLength; i++) {
            reducedArray[i] = removedArray[i];
        }

        return reducedArray;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int matchArr1Arr2 = 0;
        for (int num : arr1) {
            if (getFirstIndex(arr2, num) != -1) {
                ++matchArr1Arr2;
            }
        }

        if (matchArr1Arr2 != arr1.length) {
            return false;
        }

        int matchArr2Arr1 = 0;
        for (int num : arr2) {
            if (getFirstIndex(arr1, num) != -1) {
                ++matchArr2Arr1;
            }
        }

        return matchArr2Arr1 == arr1.length;
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
        if (arr.length == 0) {
            return new int[0];
        }

        int[] shiftArray = new int[arr.length];
        shiftArray[0] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            shiftArray[i] = arr[i - 1];
        }

        return shiftArray;
    }
}
