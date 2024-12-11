package com.walking.intensive.chapter5.task20;

/**
 * Создайте метод, возвращающий определитель матрицы (R) ранга N и дополнительный метод валидации,
 * который будет определять, что матрица является квадратной и у нее может быть рассчитан определитель.
 *
 * <p>Описание основного метода:
 *
 * <ul>
 * <li>Метод может реализовывать рекурсивный алгоритм подсчета определителя (A или <i>det A</i>)
 *      разложением по элементам первой строки. Можно ознакомиться
 *      <a href="https://portal.tpu.ru/SHARED/k/KONVAL/Sites/Russian_sites/2/06_e1.htm">здесь</a>.
 * <li>Метод должен проверять, является ли матрица квадратной.
 * <li>Метод должен принимать в качестве аргумента двумерный массив.
 * <li>В случае некорректных входных данных метод должен возвращать null.
 * </ul>
 *
 * <p>P.S. Алгоритмы для расчета могут быть как рекурсивными, так и нет.
 *
 * <p>P.P.S. Решение не должно использовать встроенные методы сортировки, коллекции,
 * Stream API и иной материал, выходящий за рамки пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task20 {
    public static void main(String[] args) {
        System.out.println(getDeterminant(new int[][] {
                {0, 3, 5, 8, 7},
                {1, 4, 3, 7, 9},
                {6, 2, 1, 5, 5},
                {0, 4, 2, 1, 3},
                {6, 4, 2, 8, 9}
        }));
    }

    /**
     * Входное значение - матрица, представленная в виде двумерного массива.
     *
     * <p>Пояснение о типе Integer: это ссылочный тип - класс-обертка над int.
     * В основном курсе вы сможете ознакомиться с такими типами подробнее.
     * Вы можете работать со значением Integer как с обычной переменной типа int,
     * но также у нее есть и другие возможности. В данной задаче нам этот тип нужен только
     * для возможности вернуть в случае ошибки не числовое значение - null.
     *
     * <p>Позже вы познакомитесь с концепцией исключений, что упростит обработку ошибок.
     * До тех пор приходится находить обходные пути для обозначения ситуаций, когда что-то пошло не по плану.
     */
    static Integer getDeterminant(int[][] matrix) {
        if (!isValid(matrix)) {
            return null;
        }

        if (matrix.length == 2) {
            return getDeterminantSize2(matrix);
        }

        int result = 0;

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[0][j] == 0) {
                continue;
            }

            result += (int) (Math.pow(-1, 2 + j)) * matrix[0][j] * getDeterminant(getNewArray(matrix, j));
        }

        return result;
    }

    private static int getDeterminantSize2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    /**
     * Входное значение - валидируемая матрица, представленная в виде двумерного массива.
     *
     * <p>Метод должен возвращать true, если у матрицы может быть рассчитан определитель. В противном случае - false.
     *
     * <p>Логика валидации должна быть определена в этом методе, чтобы не усложнять логику getDeterminant(). При этом
     * getDeterminant() должен использовать isValid().
     */
    static boolean isValid(int[][] matrix) {
        if (matrix == null) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                return false;
            }
        }

        return true;
    }

    private static int[][] getNewArray(int[][] matrix, int y) {
        int[][] buffer = new int[matrix.length - 1][matrix.length - 1];

        int indexI = 0;
        int indexJ = 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == y) {
                    continue;
                }

                buffer[indexI][indexJ++] = matrix[i][j];
            }

            indexI++;
            indexJ = 0;
        }

        return buffer;
    }
}
