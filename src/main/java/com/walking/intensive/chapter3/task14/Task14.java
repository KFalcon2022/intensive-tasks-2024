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
//        Для собственных проверок можете делать любые изменения в этом методе
        int[][] objectLocations = new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] radars = new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};

        System.out.println(Arrays.toString(getObjectCounts(objectLocations, radars)));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        // Ваш код
        int[] objectCounts = new int[radars.length];

        for (int i = 0; i < radars.length; i++) {
            if (radars[i].length != 3 || radars[i][2] < 0) {
                return new int[]{};
            }

            int count = 0;

            for (int j = 0; j < objectLocations.length; j++) {
                if (objectLocations[j].length != 2) {
                    return new int[]{};
                }

                int objectX = objectLocations[j][0];
                int objectY = objectLocations[j][1];
                int radarX = radars[i][0];
                int radarY = radars[i][1];
                int radius = radars[i][2];

                double distance = Math.sqrt(Math.pow(objectX - radarX, 2) + Math.pow(objectY - radarY, 2));
                if (distance <= radius) {
                    count++;
                }
            }
            objectCounts[i] = count;
        }

        return objectCounts;
    }
}
