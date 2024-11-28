package com.walking.intensive.chapter4.task17;

import java.util.Random;

/**
 * Смауг, живущий в пещере с золотом, был заперт внутри горы.
 * Чтобы занять свое время, он развлекал себя следующей игрой.
 * Он складывал произвольное количество одинаковых монеток по мешочкам,
 * расставлял их в ряд произвольным образом и придумывал алгоритмы,
 * которыми он будет пользоваться для того, чтобы расставить мешочки в порядке возрастания ценности.
 * Времени было много и у него получилось придумать десятки алгоритмов
 * с целью выбрать лучший, который справится с сортировкой за минимальное количество действий.
 *
 * <p>Сортировка — алгоритм расположения элементов массива по неубыванию (возрастанию, если элементы не повторяются).
 *
 * <p>Создайте два метода сортировки: пузырьком и quicksort. Описание алгоритмов вы найдете ниже.
 *
 * <p>
 * При использовании встроенных методов сортировок, коллекций, Stream API и иного материала,
 * выходящего за рамки пройденного курса, задача не принимается к проверке.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task17 {
    public static void main(String[] args) {

    }

    /**
     * Сортировка пузырьком:
     *
     * <ol>
     * <li> Метод заключается в попарном сравнении соседних элементов в массиве слева направо.
     *      Сначала сравнивается 0 и 1 индексы в массиве.
     *      Если значения элемента с 0-м индексом больше элемента с 1-м индексом -
     *      элементы меняются местами.
     * <li> Потом сравниваются 1 и 2 индексы, и так последовательно попарно сравниваются все элементы массива.
     *      При этом максимальный элемент массива окажется самым правым в массиве.
     * <li> Далее массивом будем считать неотсортированную часть массива,
     *      то есть без последнего самого правого элемента.
     * <li> Повторяем шаги 1 и 2 до полной сортировки массива.
     * </ol>
     */
    static int[] sortByBubble(int[] array) {
        if (!isCorrectArray(array)) {
            return new int[] {};
        }

        int buffer;

        int[] sortedArray = array.clone();

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 1; j < sortedArray.length - i; j++) {
                if (sortedArray[j] < sortedArray[j - 1]) {
                    buffer = sortedArray[j];
                    sortedArray[j] = sortedArray[j - 1];
                    sortedArray[j - 1] = buffer;
                }
            }
        }

        return sortedArray;
    }
    /**
     * Быстрая сортировка, она же QuickSort:
     *
     * <p>Это рекурсивный метод, основанный на разделении 1 массива на 2 подмассива
     * по принципу поиска опорного элемента. Далее каждый из двух массивов снова
     * рекурсивно вызывает тот же метод сортировки.
     *
     * <p>Разбиение 1 массива на 2 подмассива происходит поиском «опорного элемента».
     *
     * <p>Опорный элемент делит массив таким образом, что элементы, меньшие опорного,
     * помещаются перед ним(левее), а большие или равные — после(правее).
     * При этом сам опорный элемент не обязан быть элементом массива.
     *
     * <p>Вопрос выбора лучшего опорного элемента пока остается открытым в математике.
     * Цель опорного элемента — попытаться разделить массив пополам,
     * тогда сортировка пройдет максимально быстро.
     * В задаче опорный элемент = (max + min) / 2
     * (считается каждый раз для каждого нового подмассива).
     * Где max и min — максимальный и минимальный элементы массива (подмассива).
     *
     * <ol>
     * <li> В одном цикле два итератора: i слева направо от left до right,
     *      j – справа налево от right до left, где left и right индексы,
     *      вставляемые в метод в качестве аргументов. Ищем значение опорного элемента.
     * <li> Пока i <= j: двигаем i, пока не встретим элемент, который >= опорного элемента.
     *      Двигаем j, пока не встретим элемент, который <= опорного элемента.
     *      Если i <= j, то делаем обмен элементов по этим индексам.
     *      Нужно добиться, чтобы каждый элемент слева от опорного элемента
     *      был <= опорного элемента, а каждый элемент спрва от
     *      опорного элемента был >= опорного элемента.
     *      Таким способом мы найдем индекс опорного элемента в массиве или
     *      2 соседних индекса, если опорного элемента в массиве нет.
     * <li> Мы узнали индекс опорного элемента и добились того, что опорный элемент
     *      поделил массив на 2 массива. Осталось каждый подмассив поставить
     *      в качестве аргумета вызывая рекурсию.
     * <li> Выход из рекурсии: массив длины 2 – если нужно,
     *      меняем эти два элемента местами.
     *      Если длина входного массива меньше двух, выходим.
     * </ol>
     */
    static int[] sortByQuicksort(int[] array) {
        if (array == null) {
            return new int[] {};
        }

        if (array.length < 2 ||  isEqualElements(array)) {
            return array;
        }

        if (array.length == 2) {
            if (array[0] > array[1]) {
                int buffer = array[0];
                array[0] = array[1];
                array[1] = buffer;
            }

            return array;
        }

        int baseElement = (getMax(array) + getMin(array)) / 2;

        int[] leftArray = new int[] {};
        int[] rightArray = new int[] {};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < baseElement) {
                leftArray = add(leftArray, array[i]);
            } else {
                rightArray = add(rightArray, array[i]);
            }
        }

        return getUnionArray(sortByQuicksort(leftArray), sortByQuicksort(rightArray));
    }

    /**
     * Создайте массив случайных целых чисел из 1 000 элементов и сравните время,
     * которое потребуются для каждой из сортировок.
     * Ожидаемое возвращаемое значение - разница в выполнении сортировки в миллисекундах.
     *
     * <p>Для получения текущего UNIX-времени (в миллисекундах) можно использовать `System.currentTimeMillis()`.
     * Время выполнения - разность времени после работы алгоритма и времени до работы алгоритма
     */
    static long getBenchmarkOn1000() {
        int[] arr = getRandomArray(1000, 10000);

        long algorithmTimeBefore = System.currentTimeMillis();

        sortByBubble(arr);

        long algorithmTimeAfter = System.currentTimeMillis();

        return algorithmTimeAfter - algorithmTimeBefore;
    }

    /**
     * Повторите предыдущие вычисления из метода getBenchmarkOn1000() для массива в 10 000 элементов.
     */
    static long getBenchmarkOn10000() {
        int[] arr = getRandomArray(10000, 1000);

        long algorithmTimeBefore = System.currentTimeMillis();

        sortByBubble(arr);

        long algorithmTimeAfter = System.currentTimeMillis();

        return algorithmTimeAfter - algorithmTimeBefore;
    }

    private static boolean isCorrectArray(int[] arr) {
        return arr != null && arr.length > 1;
    }

    private static int[] getRandomArray(int arraySize, int range) {
        int[] result = new int[arraySize];

        Random rand = new Random();

        for (int i = 0; i < result.length; i++) {
            result[i] = rand.nextInt(range);
        }

        return result;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    private static int[] add(int[] arr, int value) {
        int[] result = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        result[result.length - 1] = value;

        return result;
    }

    private static int[] getUnionArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        
        return result;
    }

    private static boolean isEqualElements(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
