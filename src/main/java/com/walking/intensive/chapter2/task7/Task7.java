package com.walking.intensive.chapter2.task7;

/**
 * Пятиклассник Ваня придумал забаву. Он ввел понятие «дружественной пары» чисел.
 * Два различных натуральных числа N и M он назвал дружественными, если сумма делителей числа N
 * (включая 1, но исключая само N) равна числу M и наоборот.
 *
 * <p>Например, 220 и 284 – дружественные числа:
 *
 * <ul>
 * <li>Список делителей для 220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110. Их сумма равна 284;
 * <li>Список делителей для 284: 1, 2, 4, 71, 142. Их сумма равна 220.
 * </ul>
 *
 * <p>Реализуйте метод getFriendlyPair(), который принимает параметром число N,
 * где N - натуральное число не больше 1 000 000.
 *
 * <p>Метод должен вернуть наибольшее число из пары дружественных чисел,
 * сумма дружественных чисел которой максимальна среди всех пар дружественных
 * чисел, большее из которых меньше N.
 *
 * <p> Если входные данные некорректны - метод должен возвращать -1.
 *
 * <p>P.S. Решение не должно использовать массивы и прочие темы, которые пока не были затронуты в курсе.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task7 {
    public static void main(String[] args) {
//        System.out.println(dividersSum(30));

//        for (int i = 0; i < 285; i++) {
//            System.out.print(getFriendlyPair(i));
//        }
//        System.out.println(getFriendlyPair(285));

        // Какая жесть это ваше программирование. Уйду в проститутки.
        long before = System.currentTimeMillis();
        System.out.println(getFriendlyPair(100_000));
        System.out.println(System.currentTimeMillis() - before + " ms");

        long before1 = System.currentTimeMillis();
        System.out.println(getFriendlyPair(1_000_000));
        System.out.println(System.currentTimeMillis() - before1 + " ms");
        // Пятикласснику Ване здоровья.
    }

    static int getFriendlyPair(int n) {
        if (n <= 0 || n > 1_000_000) {
            return -1;
        }

        int maxSum = 0;
        int result = 0;

        for (int i = 2; i < n; i++) {
            int sumDivI = dividersSum(i);

            if (isFriendlyPair(i, sumDivI, n)) {
                int currentSum = i + sumDivI;

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    result = sumDivI;
                }
            }
        }

        return result;
    }

    private static int dividersSum(int number) {
        int sum = 1;

        int sqrtNum = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrtNum; i++) {
            if (number % i == 0) {
                sum += i;

                int divider = number / i;
                if (divider != i && divider != number) {
                    sum += divider;
                }
            }
        }
        return sum;
    }

    private static boolean isFriendlyPair(int i, int sumDivI, int n) {
        if (sumDivI > i && sumDivI < n) {
            int sumDivJ = dividersSum(sumDivI);
            return sumDivJ == i;
        }
        return false;
    }
}
