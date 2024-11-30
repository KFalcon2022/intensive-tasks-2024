package com.walking.intensive.chapter2.task10;

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
        System.out.println(isPalindrome("Ежу хуже"));
    }

    static boolean isPalindrome(String inputString) {
        if (!isValidValue(inputString)) {
            return false;
        }

        inputString = deleteSpaces(inputString);
        return new StringBuilder(inputString).reverse().toString().equals(inputString);
    }


    private static String deleteSpaces(String inputString) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char temp = inputString.charAt(i);
            if (Character.isLetter(temp)) {
                result.append(temp);
            }
        }

        return result.toString().toLowerCase();
    }

    private static boolean isValidValue(String inputString) {
        return inputString != null && inputString.length() > 1;
    }
}