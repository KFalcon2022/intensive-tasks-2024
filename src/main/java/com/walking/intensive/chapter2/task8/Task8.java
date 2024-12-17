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
        int happyTicketsQuantity = 0;

        for (int i = 0; i <= 999999; i++) {
            int firstNumber = i/100000;
            int secondNumber = (i/10000)%10;
            int thirdNumber = (i/1000)%10;
            int fourthNumber = (i/100)%10;
            int fifthNumber = (i/10)%10;
            int sixthNumber = i%10;

            if (isHappyTicket(firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixthNumber)){
                happyTicketsQuantity++;
            }
        }

        return (double) happyTicketsQuantity/ 1000000;
    }

    static boolean isHappyTicket (int first, int second, int third, int fourth, int fifth, int sixth){
        return (first + second + third == fourth + fifth + sixth);
    }
}
