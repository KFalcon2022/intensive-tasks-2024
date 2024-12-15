package com.walking.intensive.chapter4.task17;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(sortByBubble(new int[]{5, 4, 17, 2})));
        System.out.println(Arrays.toString(sortByQuicksort(new int[]{5, 4, 17, 2})));
        System.out.println(Arrays.toString(sortByQuicksort(new int[]{3, 2, 3, 5, 2, 1, 2, 1})));
        System.out.println(getBenchmarkOn1000());
        System.out.println(getBenchmarkOn10000());
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
        if (array == null) {
            return new int[]{};
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }

        return array;
    }

    static void swap(int[] array, int index1, int index2) {
        array[index1] = array[index1] ^ array[index2];
        array[index2] = array[index1] ^ array[index2];
        array[index1] = array[index1] ^ array[index2];
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
     *      был <= опорного элемента, а каждый элемент справа от
     *      опорного элемента был >= опорного элемента.
     *      Таким способом мы найдем индекс опорного элемента в массиве или
     *      2 соседних индекса, если опорного элемента в массиве нет.
     * <li> Мы узнали индекс опорного элемента и добились того, что опорный элемент
     *      поделил массив на 2 массива. Осталось каждый подмассив поставить
     *      в качестве аргумента вызывая рекурсию.
     * <li> Выход из рекурсии: массив длины 2 – если нужно,
     *      меняем эти два элемента местами.
     *      Если длина входного массива меньше двух, выходим.
     * </ol>
     */
    static int[] sortByQuicksort(int[] array) {
        if (array == null) {
            return new int[]{};
        }

        quickSort(array, 0, array.length - 1);

        return array;
    }

    static void quickSort(int[] array, int left, int right) {
        if (right - left < 1) {
            return;
        }

        if (right - left == 1) {
            if (array[left] > array[right]) {
                swap(array, left, right);
            }

            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        int reference = (max + min) / 2;
        int i = left;
        int j = right;

        while (i < j) {
            if ((array[i] >= reference) && (array[j] <= reference)) {
                swap(array, i, j);
            }

            if (array[i] <= reference) {
                i++;
            }
            if (array[j] >= reference) {
                j--;
            }
        }

        quickSort(array, left, i);
        quickSort(array, j, right);
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
        return getBenchmarkOnN(1000);
    }

    /**
     * Повторите предыдущие вычисления из метода getBenchmarkOn1000() для массива в 10 000 элементов.
     */
    static long getBenchmarkOn10000() {
        return getBenchmarkOnN(10000);
    }

    static long getBenchmarkOnN(int n) {
        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            array1[i] = (int) ((Math.random() - 0.5) * Integer.MAX_VALUE);
            array2[i] = array1[i];
        }

        long currentTime = System.currentTimeMillis();
        sortByBubble(array1);
        long bubbleSortTime = System.currentTimeMillis() - currentTime;
        currentTime = System.currentTimeMillis();
        sortByQuicksort(array2);
        long quickSortTime = System.currentTimeMillis() - currentTime;

        return bubbleSortTime - quickSortTime;
    }
}
