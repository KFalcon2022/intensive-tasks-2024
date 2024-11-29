package com.walking.intensive.chapter2.task8;

//import java.util.Arrays;

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

    static boolean isHappyTicket(int ticketNumber) {

        int triad1 = ticketNumber / 1000;
        int triad2 = ticketNumber % 1000;

        return triad1 / 100 + triad1 % 100 / 10 + triad1 % 10 == triad2 / 100 + triad2 % 100 / 10 + triad2 % 10;
    }

    static double getHappyTicketChance() {

        int countHappyTickets = 0;

        for (int i = 0; i <= 999999; i++) {
            countHappyTickets += isHappyTicket(i) ? 1 : 0;
        }

        return countHappyTickets / 1E+6;
    }

}
