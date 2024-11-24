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
//        Для собственных проверок можете делать любые изменения в этом методе

        int N = 100; // Пример
        int result = getFriendlyPair(N);
        System.out.println("Наибольшее число из дружественной пары: " + result);
    }

    static int getFriendlyPair(int n) {

        if (n <= 1 || n > 1000000) {
            return -1; // Некорректные данные
        }

        int maxFriendlyNumber = 0;
        int maxSum = 0;

        for (int i = 1; i < n; i++) {
            int sumDivisorsI = getSumDivisors(i);
            if (sumDivisorsI < n && sumDivisorsI != i) { // Убедимся, что это не само число
                int sumDivisorsJ = getSumDivisors(sumDivisorsI);
                if (sumDivisorsJ == i && sumDivisorsI > i) { // Проверяем, являются ли числа дружественными
                    int currentSum = i + sumDivisorsI;
                    if (currentSum > maxSum) { // Проверяем, максимальна ли сумма
                        maxSum = currentSum;
                        maxFriendlyNumber = sumDivisorsI;
                    }
                }
            }
        }
        return maxFriendlyNumber; // Возвращаем наибольшее число из пары, или -1, если не найдено
    }

    static int getSumDivisors(int number) { // Метод для вычисления суммы делителей числа

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
