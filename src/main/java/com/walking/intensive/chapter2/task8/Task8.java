package com.walking.intensive.chapter2.task8;

import java.util.Locale;

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

    /**
     * решение через биноминальные коэффициенты и замену 3-х цифр билета их дополнением до 9,
     * чтобы получить сумму цифр билета = 27
     * подсмотренно на сайте https://www.ega-math.narod.ru/Quant/Tickets.htm раздел "Счастливые
     * троллейбусные билеты"
     */

    static Double getHappyTicketChance() {

        Locale.setDefault(Locale.ENGLISH);

        double uniqueNumAmount = 10; // количество используемых уникальных цифр от 0 до 9 включительно
        double sizeTicket = 6;  // количество цифр в билетике
        double maxHalfSum = sizeTicket * (uniqueNumAmount - 1) / 2; // максимальная сумма на половину йифр билета
        double diffTicketsNum = Math.pow(uniqueNumAmount, sizeTicket); // количество уникальных комбинаций цифр в билетиках
        double happyTicketAmount = 0;

        for (int i = 0; i < 3; i++) {
            double bin = maxHalfSum + sizeTicket - uniqueNumAmount * i - 1;
            happyTicketAmount += Math.pow(-1, i) * getBinomCoef(sizeTicket, i) * getBinomCoef(bin, sizeTicket - 1);
        }

        return Double.parseDouble(String.format("%.6f", happyTicketAmount / diffTicketsNum));
    }

    static double getFactorial(double n) {
        if (n <= 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    static double getBinomCoef(double n, double k) {
        return getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
    }
}
