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

        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {

        double happyTicketsAmount = 0;
        int firstPartNumber = 0;
        int secondPartNumber = 0;

        for (int i = 0; i <= 999; i++) {
            int digit1 = i / 100;
            int digit2 = i / 10 % 10;
            int digit3 = i % 10;

            firstPartNumber = digit1 + digit2 + digit3;

            for (int j = 0; j <= 999; j++) {
                int digit4 = j / 100;
                int digit5 = j / 10 % 10;
                int digit6 = j % 10;

                secondPartNumber = digit4 + digit5 + digit6;

                if (firstPartNumber == secondPartNumber) {
                    happyTicketsAmount += 1;
                }
            }
        }

        return happyTicketsAmount / 1000000;
    }
}
