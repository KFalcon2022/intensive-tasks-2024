package com.walking.intensive.chapter2.task10;

import java.util.Scanner;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фразу: ");
        String phrase = in.nextLine();
        in.close();

        System.out.println(isPalindrome(phrase));

    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.isEmpty()) {
            return false;
        }

        inputString = inputString.toLowerCase();
        int leftIndex = 0;
        int rightIndex = inputString.length() - 1;
        char left = inputString.charAt(leftIndex);
        char right = inputString.charAt(rightIndex);

        if (leftIndex == rightIndex) {
            return false;
        }

        for (int i = 0; i < inputString.length(); i++) {
            boolean isLetter = Character.isLetter(inputString.charAt(i));
            if (isLetter) {
                break;
            }
            return false;
        }

        while (rightIndex > leftIndex) {

            if (!Character.isLetter(left)) {
                leftIndex++;
            } else if (!Character.isLetter(right)) {
                rightIndex--;
            } else if (Character.isLetter(left) && Character.isLetter(right)) {
                boolean equal = left == right;
                if (!equal) {
                    return false;
                }
            }

            rightIndex--;
            leftIndex++;
        }

        return true;
    }
}
