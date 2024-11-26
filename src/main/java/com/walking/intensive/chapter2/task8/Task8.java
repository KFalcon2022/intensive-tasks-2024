package com.walking.intensive.chapter2.task8;

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {

        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {

        int[] sumOfDigits = new int[28];
        int currentDigit;
        int summ;

        for (int i = 1; i < 1000; i++) {
            currentDigit = i;
            summ = 0;

            while (currentDigit > 0) {
                summ += currentDigit % 10;
                currentDigit /= 10;
            }

            sumOfDigits[summ]++;
        }

        sumOfDigits[0] = 1;                 //Вероятность выпадения комбинации 000 = 1/1000

        double totalChance = 0;

        for (int i = 0; i < 28; i++) {
            totalChance += Math.pow(sumOfDigits[i], 2);
        }

        return totalChance/1000000;
    }
}
