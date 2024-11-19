package com.walking.intensive.chapter2.task8;

import java.util.Arrays;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {
        int[] sumFrequency = new int[28];

        for (int i = 0; i < 1000; i++) {
            int sum = (i / 100) + (i / 10 % 10) + (i % 10);
            sumFrequency[sum]++;
//            [1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1]
        }
        System.out.println(Arrays.toString(sumFrequency));
    }

    static double getHappyTicketChance() {
        int totalTickets = 1_000_000;

        int[] sumFrequency = calculateSumFrequency();

        int happyTickets = calculateHappyTickets(sumFrequency);

        return (double) happyTickets / totalTickets;
    }

    private static int[] calculateSumFrequency() {
        int[] sumFrequency = new int[28];

        for (int i = 0; i < 1000; i++) {
            int sum = (i / 100) + (i / 10 % 10) + (i % 10);
            sumFrequency[sum]++;
        }
        return sumFrequency;
    }

    private static int calculateHappyTickets(int[] sumFrequency) {
        int happyTickets = 0;

        for (int sum = 0; sum <= 27; sum++) {
            happyTickets += sumFrequency[sum] * sumFrequency[sum];
        }
        return happyTickets;
    }
}
