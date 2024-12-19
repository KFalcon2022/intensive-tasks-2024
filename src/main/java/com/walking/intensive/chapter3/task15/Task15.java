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

        int[][] city = {{2, 1}, {1, 3}};
        System.out.println(getMaxFloors(city));
    }

    static int getMaxFloors(int[][] city) {

        if (!isValidCity(city)) {
            return -1;
        }

        int n = city.length;
        int m = city[0].length;

        int[] maxRow = new int[n];
        int[] maxCol = new int[m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                maxRow[r] = Math.max(maxRow[r], city[r][c]);
                maxCol[c] = Math.max(maxCol[c], city[r][c]);
            }
        }

        int totalFloors = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int maxAllowedHeight = Math.min(maxRow[r], maxCol[c]);
                totalFloors += maxAllowedHeight - city[r][c];
            }
        }

        return totalFloors;
    }

    private static boolean isValidCity(int[][] city) {

        if (city.length == 0) {
            return false;
        }

        int cityLength = city.length;

        for (int i = 0; i < cityLength - 1; i++) {
            if (city[i].length != cityLength) {
                return false;
            }

            for (int j = 0; j < cityLength; j++) {
                if (city[i][j] < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
