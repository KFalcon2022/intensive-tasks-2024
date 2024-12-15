package com.walking.intensive.chapter4.task17;


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
//        Для собственных проверок можете делать любые изменения в этом методе
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
        // Ваш код
        if (array == null) {
            return new int[0];
        }

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tempElement = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tempElement;
                }
            }
        }
        return array;
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
        // Ваш код
        qSort(array, 0, array.length - 1);
        return array;
    }

    static void qSort(int[] array, int left, int right) {
        if (right - left < 1) {
            return;
        }

        if (right - left == 1) {
            if (array[left] > array[right]) {
                int tempElement = array[right];
                array[right] = array[left];
                array[left] = tempElement;
            }
            return;
        }

        int maxElement = array[left];
        int minElement = array[left];

        for (int i = left; i <= right; i++) {
            int element = array[i];
            maxElement = Math.max(element, maxElement);
            minElement = Math.min(element, minElement);
        }

        int pivot = (maxElement + minElement) / 2;

        int i = left;
        int j = right;

        while (i <= j) {
            if (array[i] >= pivot && array[j] <= pivot) {
                int tempElement = array[j];
                array[j] = array[i];
                array[i] = tempElement;
                i++;
                j--;
            }

            if (array[i] < pivot) {
                i++;
            }
            if (array[j] > pivot) {
                j--;
            }
        }

        qSort(array, left, i - 1);
        qSort(array, i, right);
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
        // Ваш код
        int length = 100;
        int[] randomArray1 = new int[length];
        int[] randomArray2 = new int[length];
        for (int i = 0; i < randomArray1.length; i++) {
            randomArray1[i] = (int) (Math.random() * 1000);
            randomArray2[i] = randomArray1[i];
        }

        long startTime = System.currentTimeMillis();
        sortByBubble(randomArray1);
        long stopTime = System.currentTimeMillis();
        long resultTime1 = stopTime - startTime;

        startTime = System.currentTimeMillis();
        sortByQuicksort(randomArray2);
        stopTime = System.currentTimeMillis();
        long resultTime2 = stopTime - startTime;

        return resultTime1 - resultTime2;
    }

    /**
     * Повторите предыдущие вычисления из метода getBenchmarkOn1000() для массива в 10 000 элементов.
     */
    static long getBenchmarkOn10000() {
        // Ваш код
        int length = 10_000;
        int[] randomArray1 = new int[length];
        int[] randomArray2 = new int[length];
        for (int i = 0; i < randomArray1.length; i++) {
            randomArray1[i] = (int) (Math.random() * 1000);
            randomArray2[i] = randomArray1[i];
        }

        long startTime = System.currentTimeMillis();
        sortByBubble(randomArray1);
        long stopTime = System.currentTimeMillis();
        long resultTime1 = stopTime - startTime;

        startTime = System.currentTimeMillis();
        sortByQuicksort(randomArray2);
        stopTime = System.currentTimeMillis();
        long resultTime2 = stopTime - startTime;

        return resultTime1 - resultTime2;
    }
}
