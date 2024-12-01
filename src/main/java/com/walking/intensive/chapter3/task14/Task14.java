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
        int[][] pointsOne = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queriesOne = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};

        System.out.println(Arrays.toString(getObjectCounts(pointsOne, queriesOne)));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        if (!isValid(objectLocations, radars)) {
            return new int[]{};
        }

        int len = radars.length;
        int[] objectsCount = new int[len];

        int centerX;
        int centerY;
        int radius;
        int counts;

        for (int i = 0; i < len; i++) {
            centerX = 0;
            centerY = 0;
            radius = 0;

            for (int j = 0; j < 1; j++) {
                centerX = radars[i][0];
                centerY = radars[i][1];
                radius = radars[i][2];
            }

            counts = getCounts(objectLocations, centerX, centerY, radius);
            objectsCount[i] = counts;
        }

        return objectsCount;
    }

    private static int getCounts(int[][] objectLocations, int centerX, int centerY, int radius) {
        int count = 0;
        int x;
        int y;

        for (int[] objectLocation : objectLocations) {
            x = 0;
            y = 0;

            for (int j = 0; j < 1; j++) {
                x = objectLocation[0];
                y = objectLocation[1];
            }

            if (isRadarZone(centerX, centerY, x, y, radius)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isRadarZone(int centerX, int centerY, int x, int y, int radius) {
        double dx = centerX - x;
        double dy = centerY - y;

        dx *= dx;
        dy *= dy;

        double distanceSquared = dx + dy;
        double radiusSquared = radius * radius;

        return distanceSquared <= radiusSquared;
    }

    private static boolean isValid(int[][] objects, int[][] radar) {
        for (int[] ints : objects) {
            if (ints.length != 2) {
                return false;
            }

            for (int anInt : ints) {
                if (anInt < 0) {
                    return false;
                }
            }
        }

        for (int[] ints : radar) {
            if (ints.length != 3) {
                return false;
            }

            for (int anInt : ints) {
                if (anInt < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
