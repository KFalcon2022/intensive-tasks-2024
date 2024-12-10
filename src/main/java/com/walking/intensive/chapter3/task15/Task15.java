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
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static int getMaxFloors(int[][] city) {
        if (!isValidCity(city)) {
            return -1;
        }

        int maxFloors = 0;
        int[] maxHeightRawArray = new int[city.length];
        int[] maxHeightColArray = new int[city.length];
        for (int i = 0; i < city.length; i++) {
            int maxHeightR = city[i][0];
            int maxHeightC = city[0][i];
            for (int j = 0; j < city[i].length; j++) {
                if (maxHeightR < city[i][j]) {
                    maxHeightR = city[i][j];
                }
                if (maxHeightC < city[j][i]) {
                    maxHeightC = city[j][i];
                }
            }
            maxHeightRawArray[i] = maxHeightR;
            maxHeightColArray[i] = maxHeightC;
        }

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (Math.min(maxHeightRawArray[i], maxHeightColArray[j]) - city[i][j] > 0) {
                    maxFloors += Math.min(maxHeightRawArray[i], maxHeightColArray[j]) - city[i][j];
                }
            }
        }

        return maxFloors;
    }

    static boolean isValidCity(int[][] city) {
        if (city.length == 0) {
            return false;
        }

        for (int[] street : city) {
            if (street.length != city.length) {
                return false;
            }
            for (int height : street) {
                if (height < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
