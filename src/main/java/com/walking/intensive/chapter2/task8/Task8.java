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

        int[] digits = new int[6];
        int counter = 0;

        while (true) {

            if ((digits[0] + digits[1] + digits[2]) == (digits[3] + digits[4] + digits[5])) {
                counter++;
            }

            for (int i = 5; i >= 0; i--) {

                digits[i]++;

                if (digits[i] > 9) {

                    if (i == 0) {
                        return (double) counter / 1000000;
                    }

                    digits[i] = 0;

                } else {

                    break;
                }
            }
        }
    }
}
