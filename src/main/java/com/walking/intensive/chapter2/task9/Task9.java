package com.walking.intensive.chapter2.task9;

import java.math.BigInteger;

/**
 * Реализуйте метод getPascalTriangle(). Параметром он должен принимать натуральное число N,
 * а метод возвращать строковое представление треугольника Паскаля.
 *
 * <p>Число N — степень или количество этажей в треугольнике.
 *
 * <p>Треугольник должен быть выровнен по центру. Между соседними числами в ряду должен быть ровно 1 пробел.
 *
 * <p>Если входные данные некорректны - метод должен возвращать пустую строку.
 *
 * <p>Примеры:
 *
 * <p>Для N = 5:
 * <pre>
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 * </pre>
 *
 * <p>Для N = 18:
 *
 * <pre>
 *                                         1
 *                                        1 1
 *                                       1 2 1
 *                                      1 3 3 1
 *                                     1 4 6 4 1
 *                                   1 5 10 10 5 1
 *                                 1 6 15 20 15 6 1
 *                                1 7 21 35 35 21 7 1
 *                              1 8 28 56 70 56 28 8 1
 *                            1 9 36 84 126 126 84 36 9 1
 *                        1 10 45 120 210 252 210 120 45 10 1
 *                      1 11 55 165 330 462 462 330 165 55 11 1
 *                    1 12 66 220 495 792 924 792 495 220 66 12 1
 *                1 13 78 286 715 1287 1716 1716 1287 715 286 78 13 1
 *            1 14 91 364 1001 2002 3003 3432 3003 2002 1001 364 91 14 1
 *         1 15 105 455 1365 3003 5005 6435 6435 5005 3003 1365 455 105 15 1
 *     1 16 120 560 1820 4368 8008 11440 12870 11440 8008 4368 1820 560 120 16 1
 * 1 17 136 680 2380 6188 12376 19448 24310 24310 19448 12376 6188 2380 680 136 17 1
 * </pre>
 *
 * <p>Обратите внимание - в консоли визуально получается не совсем треугольник - это нормально.
 * Также обращаю внимание на то, что "основание" треугольника не должно иметь лишних отступов.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task9 {
    public static void main(String[] args) {
        System.out.println(getPascalTriangle(15));
    }

    /**
     * Возвращает строковое представление треугольника Паскаля,
     * где n - количество строк (уровней) треугольника.
     *
     * @param n количество строк треугольника
     * @return строковое представление треугольника Паскаля
     */

    static String getPascalTriangle(int n) {

        if (n <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int maxRowLength = calculateMaxRowLength(n);

        for (int row = 0; row < n; row++) {
            String rowString = generateRow(row);
            int leadingSpaces = (maxRowLength - rowString.length()) / 2;

            result.append(" ".repeat(leadingSpaces));
            result.append(rowString);
            result.append("\n");
        }

        return result.toString();
    }

    /**
     * Генерирует строку для заданного уровня треугольника Паскаля.
     *
     * @param row уровень треугольника
     * @return строковое представление строки
     */

    private static String generateRow(int row) {
        StringBuilder rowBuilder = new StringBuilder();

        for (int i = 0; i <= row; i++) {
            rowBuilder.append(pascal(row, i).toString());

            if (i < row) {
                rowBuilder.append(" ");
            }
        }
        return rowBuilder.toString();
    }

    /**
     * Вычисляет максимальную длину строки треугольника Паскаля,
     * которая соответствует длине последней строки.
     *
     * @param n количество строк треугольника
     * @return максимальная длина строки
     */

    private static int calculateMaxRowLength(int n) {
        int length = 0;

        for (int i = 0; i < n; i++) {
            length += pascal(n - 1, i).toString().length();

            if (i < n - 1) {
                length += 1;
            }
        }
        return length;
    }

    /**
     * Вычисляет значение элемента треугольника Паскаля для заданного уровня и столбца.
     * Использует рекурсивную формулу биномиального коэффициента: C(n, k) = C(n-1, k-1) + C(n-1, k).
     *
     * @param row номер уровня (начиная с 0)
     * @param column номер столбца (начиная с 0)
     * @return значение элемента треугольника Паскаля
     */

    private static BigInteger pascal(int row, int column) {
        if (column == 0 || column == row) {
            return BigInteger.ONE;
        }

        return pascal(row - 1, column - 1).add(pascal(row - 1, column));
    }
}


