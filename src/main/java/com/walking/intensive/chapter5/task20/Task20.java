package com.walking.intensive.chapter5.task20;

import java.util.Arrays;

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
        int[][] m = {{2, -5, 3}, {1, 4, 0}, {-3, 7, 5}};
        System.out.println(Arrays.deepToString(m));
        System.out.println(getDeterminant(m));
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

        int n = matrix.length;
        int det = 0;

        if (n == 1) {
            return matrix[0][0];
        }

        for (int j = 0; j < n; j++) {
            det += (j % 2 == 0 ? 1 : -1) * matrix[0][j] * getDeterminant(getSubMatrix(matrix, 0, j));
        }

        return det;
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
        if (matrix.length < 1) {
            return false;
        }

        for (int[] row : matrix) {
            if (row.length != matrix.length) {
                return false;
            }
        }

        return true;
    }

    private static int[][] getSubMatrix(int[][] matrix, int rowToDelete, int columnToDelete) {
        int[][] subMatrix = new int[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != rowToDelete && j != columnToDelete) {
                    subMatrix[i < rowToDelete ? i : i - 1][j < columnToDelete ? j : j - 1] = matrix[i][j];
                }
            }
        }

        return subMatrix;
    }
}
