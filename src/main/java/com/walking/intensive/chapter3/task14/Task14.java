package com.walking.intensive.chapter3.task14;

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
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        if (!isArgsValid(objectLocations, radars)) {
            return new int[0];
        }

        int[] objectCounts = new int[radars.length];

        for (int i = 0; i < objectCounts.length; i++) {
            objectCounts[i] = countRadarObjects(radars[i], objectLocations);
        }
        return objectCounts;
    }

    static boolean isArgsValid(int[][] objectLocations, int[][] radars) {
        if (objectLocations.length == 0 || radars.length == 0) {
            return false;
        }

        for (int[] radar : radars) {
            if (radar.length != 3 || radar[2] <= 0) {
                return false;
            }
        }

        for (int[] object : objectLocations) {
            if (object.length != 2) {
                return false;
            }
        }
        return true;
    }

    static int countRadarObjects(int[] radar, int[][] objectLocations) {
        int radarObjects = 0;

        for (int[] object : objectLocations) {
            if (isObjectCount(radar, object)) {
                radarObjects++;
            }
        }
        return radarObjects;
    }

    static boolean isObjectCount(int[] radar, int[] object) {
        int objectX = object[0];
        int objectY = object[1];
        int radarX = radar[0];
        int radarY = radar[1];
        int radarRadius = radar[2];

        return radarRadius * radarRadius >= (objectX - radarX) * (objectX - radarX)
                + (objectY - radarY) * (objectY - radarY);
    }
}
