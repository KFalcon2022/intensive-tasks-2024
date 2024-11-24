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
        System.out.println(getCountHappyTicket());
    }

    static double getHappyTicketChance() {
        return (double) getCountHappyTicket() / 1_000_000;
    }

    private static int getCountHappyTicket() {
        int count = 0;

        for (int i = 0; i < 1_000_000; i++) {
            int leftSum = 0;
            int rightSum = 0;

            int ticket = i;

            for (int j = 0; j < 3; j++) {
                rightSum += ticket % 10;
                ticket /= 10;
            }

            for (int k = 0; k < 3; k++) {
                leftSum += ticket % 10;
                ticket /= 10;
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }
}