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

    }

    static double getHappyTicketChance() {
        int numberHappyTickets = 1;
        for (int i = 1001; i < 1000000; i++) {
            if (getSumNumbs(i) == getSumNumbs(i / 1000)) {
                numberHappyTickets++;
            }
        }
        return (double) numberHappyTickets / 1000000;
    }

    static int getSumNumbs(int n) {
        return (n % 1000 - n % 100) / 100 + (n % 100 - n % 10) / 10 + n % 10;
    }
}
