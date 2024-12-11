package com.walking.intensive.chapter3.task15;

//import java.util.Arrays;

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
//        Для собственных проверок можете делать любые изменения в этом методе
        int[][] city2 = {{}, {}, {}};
        System.out.println(getMaxFloors(city2));
    }


    static int getMaxFloors(int[][] city) {
        if (!checkInput(city)) {
            return -1;
        }

        int maxFloor = 0;

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                int maxRow = getMaxRow(city[i]);
                int maxColumn = getMaxColumn(city, j);
                if (maxColumn > maxRow) {
                    maxFloor = maxFloor + (maxRow - city[i][j]);
                } else {
                    maxFloor = maxFloor + (maxColumn - city[i][j]);
                }
            }
        }

        return maxFloor;
    }

    static int getMaxRow(int[] city) {
        int maxrow = 0;

        for (int i : city) {
            if (maxrow < i) {
                maxrow = i;
            }
        }

        return maxrow;
    }

    static int getMaxColumn(int[][] city, int col) {
        int maxcol = 0;

        for (int i = 0; i < city.length; i++) {
            if (maxcol < city[i][col]) {
                maxcol = city[i][col];
            }

        }

        return maxcol;
    }

    static boolean checkInput(int[][] city) {
        if (city.length == 0) {
            return false;
        }

        for (int i = 0; i < city.length; i++) {
            if (city[i].length == 0) {
                return false;
            }
            for (int j = 0; j < city[i].length; j++) {
                if (city[i][j] < 0 || city[i].length != city.length) {
                    return false;
                }

            }
        }

        return true;
    }
}
