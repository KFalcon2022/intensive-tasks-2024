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
    }

    static double getHappyTicketChance() {
        int leftDigits = 0;
        int rightDigits = 0;
        double getEquality = 0;
        double getProbability;

        for (int i = 0; i < 1000; i++) {
            if (i < 10) {
                leftDigits = (i % 10);
            } else if (i < 99) {
                leftDigits = i / 10 + (i % 10);
            } else {
                leftDigits = i / 100 + (i % 100) / 10 + (i % 10);
            }
            for (int j = 1; j < 1000; j++) {
                if (leftDigits == rightDigits) {
                    getEquality++;
                }
                {
                    if (j < 10) {
                        rightDigits = (j % 10);
                    } else if (j < 99) {
                        rightDigits = j / 10 + (j % 10);
                    } else {
                        rightDigits = j / 100 + (j % 100) / 10 + (j % 10);
                    }
                }
            }
        }

        return getProbability = getEquality / (999999 + 1);
    }
}
