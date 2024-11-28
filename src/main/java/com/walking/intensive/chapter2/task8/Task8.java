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
        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {
        // Ваш код
        int maxCifra = 9;
        int[] sums = new int[28];

        for (int h1 = 0; h1 <= maxCifra; h1++) {
            for (int h2 = 0; h2 <= maxCifra; h2++) {
                for (int h3 = 0; h3 <= maxCifra; h3++) {

                    int sum = h1 + h2 + h3;
                    sums[sum]++;
                }
            }
        }

        int winningcount = 0;
        for (int count : sums) {
            winningcount = winningcount + count * count;
        }

        double allcount = 1000000.0;
        double p = winningcount / allcount;
        return p;
    }
}
