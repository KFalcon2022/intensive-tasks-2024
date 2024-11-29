package com.walking.intensive.chapter3.task15;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания может быть строго положительной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1],[1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
        //          j =  0  1  2  3
        int[][] city = {{3, 0, 8, 4},  // i = 0
                {2, 4, 5, 7},  // i = 1
                {9, 2, 6, 3},  // i = 2
                {0, 3, 1, 0}}; // i = 3

        System.out.println(getMaxFloors(city));
    }

    static int getMaxFloors(int[][] city) {
        if (!isValidate(city)) {
            return -1;
        }

        int floors = 0;

        for (int i = 0; i < city.length; i++) {

            // находим максимальную высоту этожа на i - горизонтали
            int maxHorizon = getMaxHorizonFloor(city, i);
            int maxVertical;

            for (int j = 0; j < city[i].length; j++) {

                // находим максимальную высоту этажа на j - вертикали
                maxVertical = getMaxVerticalFloor(city, j);

                // находим для текущего этажа максимальную возможную пристройку
                floors += getMaxFloor(maxHorizon, maxVertical, city[i][j]);
            }

        }

        return floors;
    }

    private static int getMaxFloor(int maxHorizon, int maxVertical, int floor) {
        return Math.min(maxHorizon, maxVertical) - floor;
    }

    private static int getMaxVerticalFloor(int[][] city, int index) {
        int maxFloor = 0;

        for (int[] ints : city) {
            for (int j = index; j < index + 1; j++) {
                if (ints[j] >= maxFloor) {
                    maxFloor = ints[j];
                }
            }
        }

        return maxFloor;
    }

    private static int getMaxHorizonFloor(int[][] city, int index) {
        int maxFloor = 0;

        for (int j = 0; j < city[index].length; j++) {
            if (city[index][j] >= maxFloor) {
                maxFloor = city[index][j];
            }
        }

        return maxFloor;
    }

    private static boolean isValidate(int[][] array) {
        if (array.length < 1) {
            return false;
        }

        for (int[] ints : array) {
            if (ints.length < 1) {
                return false;
            }
        }

        int len = array[0].length;

        for (int[] ints : array) {
            if (ints.length > len || ints.length < len) {
                return false;
            }
        }

        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt < 0) return false;
            }
        }

        return true;
    }
}
