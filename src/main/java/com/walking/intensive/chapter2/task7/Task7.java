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

        System.out.println(getFriendlyPair(200));
    }
    private static int getSumDividers(int n) {

        int sumDividers = 0;

        for (int i = n - 1; i > 0; i--) {
            sumDividers += n % i == 0 ? i : 0;
        }

        return sumDividers;
    }

    static int getFriendlyPair(int n) {

        if (n < 1 || n > 1E+6) {
            return -1;
        }

        //int i = n;
        int sumDividers1;
        int sumDividers2 = 0;
        int friendlyPair1 = 0;
        int friendlyPair2 = 0;

        for (int i = n; i >= 0; i--) {
            friendlyPair1 = i;
            sumDividers1 = getSumDividers(i);
            friendlyPair2 = getSumDividers(sumDividers1);

            if (sumDividers1 != friendlyPair2) {
                sumDividers2 = friendlyPair2;
            }

            if (friendlyPair1 == sumDividers2) {
                break;
            }
        }

        return Math.max(friendlyPair1, friendlyPair2);
    }
}


