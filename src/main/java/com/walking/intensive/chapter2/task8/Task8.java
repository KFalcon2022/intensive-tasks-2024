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

        double chance = getHappyTicketChance();
        System.out.printf("Вероятность выпадения счастливого билета: %.6f%n", chance);
    }

    static double getHappyTicketChance() {

        int totalTickets = 1000000;
        int luckyTickets = 0;

        for (int ticketNumber = 0; ticketNumber < totalTickets; ticketNumber++) {

            // Преобразовываем номер билета в строку (изначально с нулями)
            String ticket = String.format("%06d", ticketNumber);

            // Получаем первые три цифры
            int firstHalfSum = (ticket.charAt(0) - '0') +
                    (ticket.charAt(1) - '0') +
                    (ticket.charAt(2) - '0'); // Преобразователь char в int

            // Получаем последние три цифры
            int secondHalfSum = (ticket.charAt(3) - '0') +
                    (ticket.charAt(4) - '0') +
                    (ticket.charAt(5) - '0'); // Преобразователь char в int

            // Проверяем, является ли билет счастливым
            if (firstHalfSum == secondHalfSum) {
                luckyTickets++;
            }
        }

        // Вычисляем вероятность
        return (double) luckyTickets / totalTickets;
    }
}
