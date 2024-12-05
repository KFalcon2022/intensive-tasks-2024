package com.walking.intensive.chapter3.task14;

import java.util.Arrays;

/**
 * Необходимо разработать программу, которая определяет количество объектов на радарах.
 *
 * <p>Реализуйте метод getObjectCounts(), который произведет указанный расчет.
 *
 * <p>Входящие параметры метода:
 *
 * <ol>
 * <li>Двумерный массив с координатами объектов, где любой objectLocations[i]
 *      содержит массив из двух точек - координат объекта по осям X и по Y соответственно;
 * <li>Двумерный массив с параметрами радаров, где любой radars[j] содержит массив со следующими данными:
 *      radars[j][0] - координата радара по оси X, radars[j][1] - координата радара по оси Y,
 *      radars[j][2] - радиус действия радара
 * </ol>
 *
 * <p>Возвращаемое значение метода - количество объектов, видимых на каждом из радаров:
 * objectCounts[j] должен содержать информацию о числе объектов, видимых на радаре radars[j].
 *
 * <p>Если объект находится точно на границе действия радара, считается,
 * что он попадает в зону действия этого радара.
 *
 * <p>Пример:
 *
 * <p>Входящие параметры: objectLocations[][] = [[1,3],[3,3],[5,3],[2,2]], radars[][] = [[2,3,1],[4,3,1],[1,1,2]].
 *
 * <p>Возвращаемое значение: objectCounts[] = [3,2,2].
 *
 * <p>Пояснение (для radars[0]):`
 *
 * <ul>
 * <li>objectCounts[0] = 3, потому что радар с координатами (2;3) и радиусом действия 1 видит объекты с координатами
 * (1;3), (2;2) и (3;3). Всего 3 объекта.
 * </ul>
 *
 * <p>При наличии некорректных входных данных верните из метода пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task14 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int[][] pointsFour = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queriesFour = {{1, 2, 1}, {2, 2}, {4, 3}, {4, 3}};
        System.out.println(Arrays.toString(getObjectCounts(pointsFour, queriesFour)));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        // Ваш код
        if (isFailArray(objectLocations, 2) || isFailArray(radars, 3)) {
            return new int[0];
        }
        int[] arrayResult = new int[radars.length];
        for (int i = 0; i < radars.length; i++) {
            for (int[] obj : objectLocations) {
                if (Math.sqrt(Math.pow(obj[0] - radars[i][0], 2) + Math.pow(obj[1] - radars[i][1], 2)) <= radars[i][2]) {
                    arrayResult[i]++;
                }
            }
        }
        return arrayResult;
    }

    static boolean isFailArray(int[][] array, int width) {

        if (array.length == 0) {
            return true;
        }

        for (int[] j : array) {
            if (j.length != width) {
                return true;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j : array[i]) {
                if (j < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
