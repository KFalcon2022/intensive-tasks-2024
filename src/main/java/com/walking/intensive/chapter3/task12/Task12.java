package com.walking.intensive.chapter3.task12;

import java.util.Arrays;

/**
 * Девочка Света очень любит играть в мячики. Она поставила в ряд корзинки и в некоторые положила по 1 мячику.
 * За 1 раз она может переложить 1 мячик в соседнюю корзинку. В 1 корзинке может поместиться много мячиков.
 *
 * <p>Необходимо помочь Свете. Реализуйте метод getMovementsNumber() с учетом условий ниже.
 *
 * <p>Входной параметр - строка, в которой закодировано положение мячиков в корзинках.
 *
 * <p>Например: "010" - всего есть три корзинки, мячик лежит только во второй.
 *
 * <p>Возвращаемое значение - массив, по размеру идентичный размеру входящей строки,
 * где arr[i] - минимальное количество операций, необходимых для перемещения всех мячиков в i-ю корзинку.
 *
 * <p> Количество необходимых операций для каждой из корзинок необходимо
 * вычислять исходя из начального расположения мячиков в корзинках.
 *
 * <p>Пример:
 *
 * <p>Входящая строка: "110"
 *
 * <p>Возвращаемое значение: [1,1,3]
 *
 * <p>Пояснение:
 *
 * <ul>
 * <li>Корзинка 1 (0-й индекс массива): треубется переложить 1 мячик из второй корзинки 1 раз.
 * <li>Корзинка 2 (1-й индекс массива): треубется переложить 1 мячик из первой корзинки во вторую 1 раз.
 * <li>Корзинка 3 (2-й индекс массива): треубется переложить 1 мячик из первой корзинки во вторую 1 раз,
 *      из второй корзинки переложить в третью 2 мякика по 1 разу, итого 3 раза.
 * </ul>
 *
 * <p>При наличии некорректных входных данных верните пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task12 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMovementsNumber("100009")));
    }

    static int[] getMovementsNumber(String baskets) {

        if (baskets.isEmpty()) {
            return new int[]{};
        }

        int n = baskets.length();
        int rightBalls = 0;
        int leftBalls = 0;
        int leftMoves = 0;
        int rightMoves = 0;
        int[] balls = new int[n];
        int[] moves = new int[n];

        for (int i = 0; i < n; i++) {

            if (!Character.isDigit(baskets.charAt(i))) {
                return new int[]{};
            }

            balls[i] = baskets.charAt(i) - '0';
            rightBalls += balls[i];
            rightMoves += i * balls[i];
        }

        rightBalls -= balls[0];
        moves[0] = rightMoves;

        for (int i = 1; i < n; i++) {

            leftBalls += balls[i - 1];
            leftMoves += leftBalls;
            rightMoves -= rightBalls;
            rightBalls -= balls[i];
            moves[i] = leftMoves + rightMoves;
        }

        return moves;
    }
}
