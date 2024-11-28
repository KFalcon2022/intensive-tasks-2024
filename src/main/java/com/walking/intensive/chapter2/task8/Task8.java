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
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {
        // Ваш код
        int maxCifra = 9;   // кол-во исходов основание, степень всегда 3
        int s = (int) Math.pow(10.0, 3.0);
        int[] sums = new int[s];
        int index = 0;
        for (int n = -1; n < maxCifra; n++) {
            int[] h1 = new int[3];
            h1[0] = n + 1;
            for (int m = -1; m < maxCifra; m++) {
                h1[1] = m + 1;
                for (int k = -1; k < maxCifra; k++) {
                    h1[2] = k + 1;
                    int sum = h1[0] + h1[1] + h1[2];
                    sums[index] = sum;
                    index++;
                  //  System.out.println(Arrays.toString(h1) + " " + sum);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < sums.length; i++) {
            boolean isDuplicate = false;
            for (int j = 1; j < sums.length; j++) {
                if (sums[i] == sums[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                count++;
            }
        }
        double p=count/1000000.0;
        return p; //return 0.0;
    }

}
