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
        long totalTickets = 1_000_000;
        int happyTickets = 0;

        for (int i = 0; i < totalTickets; i++) {
            String ticketNumber = String.format("%06d", i);

            if (isHappyTicket(ticketNumber)) {
                happyTickets++;
            }
        }
        return (double) happyTickets / totalTickets;
    }

    static boolean isHappyTicket(String ticketNumber) {
        int sumFirstThree = 0;
        int sumLastThree = 0;

        for (int i = 0; i < 3; i++) {
            sumFirstThree += Character.getNumericValue(ticketNumber.charAt(i));
        }

        for (int i = 3; i < 6; i++) {
            sumLastThree += Character.getNumericValue(ticketNumber.charAt(i));
        }

        return sumFirstThree == sumLastThree;
    }
}
