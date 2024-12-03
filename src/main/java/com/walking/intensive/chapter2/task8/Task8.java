package com.walking.intensive.chapter2.task8;

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
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static double getHappyTicketChance() {
        int happyTicketCounter = 0;

        for (int sumOfDigits = 0; sumOfDigits <= 13; sumOfDigits++) {
            int combinationCounter = 0;

            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k <= j; k++) {
                        int sum = i + j + k;
                        if (sum == sumOfDigits) {
                            combinationCounter += getNumberOfPermutation(i, j, k);
                        }
                    }
                }
            }

            happyTicketCounter += 2 * combinationCounter * combinationCounter;
        }

        return (double) happyTicketCounter / 1_000_000;
    }

    static int getNumberOfPermutation(int a, int b, int c) {
        if (a == b && a == c) {
            return 1;
        }
        if (a == b || a == c || b == c) {
            return 3;
        }
        return 6;
    }
}
