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
//        Для собственных проверок можете делать любые изменения в этом методе
        int[] arr = new int[]{1, 2, 4, 15, 66, 80};
        int[] arr1 = new int[]{4, 2, 4, 3, 4, 1};
        int[] arr2 = new int[]{4, 2, 3, 1,};
        int[] removingValues = new int[]{20, 4, 66, 250};
        int index = 4;
        int newValue = 18;
        int value = -78;

        System.out.println(isEqualSize(arr1, arr2));
        System.out.println(isEquals(arr1, arr2));
        System.out.println(Arrays.toString(incrementEach(arr)));
        System.out.println(Arrays.toString(multiplyEach(arr1, arr2)));
        System.out.println(Arrays.toString(subtractEach(arr1, arr2)));
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(Arrays.toString(add(arr, index, newValue)));
        System.out.println(isContains(arr, value));
        System.out.println(getFirstIndex(arr, value));
        System.out.println(getLastIndex(arr, value));
        System.out.println(Arrays.toString(removeByIndex(arr, index)));
        System.out.println(Arrays.toString(removeAll(arr, removingValues)));
        System.out.println(isSimilar(arr1, arr2));
        System.out.println(Arrays.toString(shiftIndex(arr)));
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {
        // Ваш код
        return arr1.length != 0 && arr2.length != 0 && arr1.length == arr2.length;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы полностью идентичны по составу.
     * В остальных случаях - false.
     *
     * <p>Идентичными считаются массивы одинаковой длины, для которых arr1[i] == arr2[i] для любого i.
     */
    static boolean isEquals(int[] arr1, int[] arr2) {
        // Ваш код
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
        // Ваш код
        if (arr.length == 0) {
            return new int[]{};
        }

        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] + 1;
        }

        return newArr;
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
        // Ваш код
        if (arr1.length == 0 && arr2.length == 0) {
            return new int[]{};
        }

        int maxlength = Math.max(arr1.length, arr2.length);
        int[] newArr1 = getNewArrayWithZero(arr1, maxlength);
        int[] newArr2 = getNewArrayWithZero(arr2, maxlength);
        int[] result = new int[maxlength];

        for (int i = 0; i < maxlength; i++) {
            result[i] = newArr1[i] * newArr2[i];
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
        // Ваш код
        if (arr1.length == 0 && arr2.length == 0) {
            return new int[]{};
        }

        int maxlength = Math.max(arr1.length, arr2.length);
        int[] newArr1 = getNewArrayWithZero(arr1, maxlength);
        int[] newArr2 = getNewArrayWithZero(arr2, maxlength);
        int[] result = new int[maxlength];

        for (int i = 0; i < maxlength; i++) {
            result[i] = newArr1[i] - newArr2[i];
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
        // Ваш код
        if (arr.length == 0) {
            return new int[]{};
        }

        int[] newArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[arr.length - i - 1];
        }

        return newArray;
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
        // Ваш код
        if (index < 0) {
            return new int[]{};
        }

        int[] newArray = new int[arr.length + 1];

        if (index > arr.length) {
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
                newArray[newArray.length - 1] = newValue;
            }
        } else {

            for (int i = 0, j = 0; i < newArray.length; i++, j++) {
                if (i == index) {
                    newArray[i] = newValue;
                    j--;
                } else {

                    newArray[i] = arr[j];
                }
            }
        }

        return newArray;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {
        // Ваш код
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
        // Ваш код
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
        // Ваш код
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
        // Ваш код
        if (index < 0) {
            return new int[]{};
        }

        if (index > arr.length) {
            return arr;
        } else {

            int[] newArray = new int[arr.length - 1];
            int newIndex = 0;

            for (int i = 0; i < arr.length; i++) {
                if (i != index) {
                    newArray[newIndex] = arr[i];
                    newIndex++;
                }
            }

            return newArray;
        }
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
        // Ваш код
        int count = 0;

        for (int i : arr) {
            for (int j : removingValues) {
                if (i == j) {
                    count++;
                    break;
                }
            }
        }

        int[] newArr = new int[arr.length - count];
        int newIndex = 0;

        for (int i : arr) {
            boolean included = false;

            for (int j : removingValues) {
                if (i == j) {
                    included = true;
                    break;
                }
            }

            if (!included) {
                newArr[newIndex] = i;
                newIndex++;
            }
        }

        return newArr;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {
        // Ваш код
        return (isMatches(arr1, arr2) && isMatches(arr2, arr1));
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
        // Ваш код
        if (arr.length == 0) {
            return new int[]{};
        }

        int[] newArr = new int[arr.length];
        newArr[0] = arr[arr.length - 1];
        int newIndex = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            newArr[newIndex] = arr[i];
            newIndex++;
        }

        return newArr;
    }

    static int[] getNewArrayWithZero(int[] array, int newLength) {
        int[] newArray = new int[newLength];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        for (int i = array.length; i < newLength; i++) {
            newArray[i] = 0;
        }

        return newArray;
    }

    static boolean isMatches(int[] array1, int[] array2) {
        for (int i : array1) {
            boolean isEqual = false;

            for (int j : array2) {
                if (i == j) {
                    isEqual = true;
                }
            }

            if (!isEqual) {
                return isEqual;
            }
        }

        return true;
    }

}
