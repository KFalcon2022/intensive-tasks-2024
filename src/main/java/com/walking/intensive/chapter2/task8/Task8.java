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
        double goodOutcomes = 0;
        double allOutcomes = 1000000;

        for (int i = 0; i < 1000000; i++) {
            int firstPartNumber1 = (i / 100000) % 10;
            int firstPartNumber2 = (i / 10000) % 10;
            int firstPartNumber3 = (i / 1000) % 10;
            int secondPartNumber1 = (i / 100) % 10;
            int secondPartNumber2 = (i / 10) % 10;
            int secondPartNumber3 = i % 10;

            int sumOfSecondNumbers = secondPartNumber1 + secondPartNumber2 + secondPartNumber3;
            int sumOfFirstNumbers = firstPartNumber1 + firstPartNumber2 + firstPartNumber3;

            if (sumOfFirstNumbers == sumOfSecondNumbers) {
                goodOutcomes++;
            }
        }

        return goodOutcomes / allOutcomes;
    }
}
