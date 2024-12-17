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
 *</ul>
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

        int[] result = getObjectCounts(objectLocations, radars);

        // Вывод результата
        for (int count : result) {
            System.out.print(count + " ");
        }
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {


        // Проверка на корректность входных данных
        if (objectLocations == null || radars == null) {
            return new int[0];
        }

        int[] objectCounts = new int[radars.length];

        // Проходим по каждому радару
        for (int j = 0; j < radars.length; j++) {
            if (radars[j].length != 3) {
                return new int[0];
            }

            int radarX = radars[j][0]; // Координата X радара
            int radarY = radars[j][1]; // Координата Y радара
            int radarRadius = radars[j][2]; // Радиус действия радара

            // Проверка на положительность радиуса
            if (radarRadius < 0) {
                return new int[0];
            }

            // Счётчик объектов, видимых на текущем радаре
            int count = 0;

            for (int[] objectLocation : objectLocations) {
                if (objectLocation.length != 2) {
                    return new int[0];
                }

                int objectX = objectLocation[0]; // Координата X объекта
                int objectY = objectLocation[1]; // Координата Y объекта

                // Находится ли объект в радиусе действия радара
                if (isInRadarRange(objectX, objectY, radarX, radarY, radarRadius)) {
                    count++; // если видим
                }
            }
            objectCounts[j] = count; // Количество видимых объектов
        }

        return objectCounts;
    }

    // Находится ли объект в радиусе действия радара
    private static boolean isInRadarRange(int objectX, int objectY, int radarX, int radarY, int radarRadius) {

        // Вычисляем квадрат расстояния между объектом и радаром
        int distanceSquared = (objectX - radarX) * (objectX - radarX) + (objectY - radarY) * (objectY - radarY);
        int radiusSquared = radarRadius * radarRadius; // Квадрат радиуса

        return distanceSquared <= radiusSquared;
    }
}
