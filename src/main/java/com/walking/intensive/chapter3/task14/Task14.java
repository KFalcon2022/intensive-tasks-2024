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
 * <p>Пояснение (для radars[0]):
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
        int[][] objectLocations = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] radars = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        System.out.println(Arrays.toString(getObjectCounts(objectLocations, radars)));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        if (!isValidInput(objectLocations, radars)) {
            return new int[0];
        }

        int[] objectCounts = new int[radars.length];

        for (int i = 0; i < radars.length; i++) {
            for (int[] objectLocation : objectLocations) {
                if (isVulnerable(objectLocation, radars[i])) {
                    objectCounts[i]++;
                }
            }
        }

        return objectCounts;
    }

    static boolean isVulnerable(int[] objectLocation, int[] radar) {
        int deltaX = objectLocation[0] - radar[0];
        int deltaY = objectLocation[1] - radar[1];
        int radarRange = radar[2];
        return (deltaX) * (deltaX) + (deltaY) * (deltaY) <= radarRange * radarRange;
    }

    static boolean isValidInput(int[][] objectLocations, int[][] radars) {
        if (objectLocations == null || objectLocations.length == 0 || radars == null || radars.length == 0) {
            return false;
        }

        for (int[] radar : radars) {
            if (radar == null || radar.length != 3 || radar[2] < 0) {
                return false;
            }
        }

        for (int[] objectLocation : objectLocations) {
            if (objectLocation == null || objectLocation.length != 2) {
                return false;
            }
        }

        return true;
    }
}
