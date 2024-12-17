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
 * расположенного в блоке в строке r и столбце c. Высота здания не может быть отрицательной.
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
    }

    static int getMaxFloors(int[][] city) {
        if (!isValid(city)) {
            return -1;
        }

        int[][] maxFloorRowColumn = new int[2][city.length];

        for (int i = 0; i < city.length; i++) {
            maxFloorRowColumn[0][i] = getMaxFloorRow(city[i]);
        }

        for (int i = 0; i < city.length; i++) {
            maxFloorRowColumn[1][i] = getMaxFloorColumn(city, i);
        }

        int maxFloors = 0;

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                maxFloors += Math.min(maxFloorRowColumn[0][i], maxFloorRowColumn[1][j]) - city[i][j];
            }
        }
        return maxFloors;
    }

    static boolean isValid(int[][] city) {
        if (city.length == 0) {
            return false;
        }

        for (int[] cityRow : city) {
            if (cityRow.length != city.length) {
                return false;
            }

            for (int building : cityRow) {
                if (building < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static int getMaxFloorRow(int[] cityRow) {
        int maxFloorRow = 0;
        for (int building : cityRow) {
            maxFloorRow = Math.max(maxFloorRow, building);
        }
        return maxFloorRow;
    }

    static int getMaxFloorColumn(int[][] city, int i) {
        int maxFloorColumn = 0;
        for (int[] cityRow : city) {
            maxFloorColumn = Math.max(maxFloorColumn, cityRow[i]);
        }
        return maxFloorColumn;
    }
}
