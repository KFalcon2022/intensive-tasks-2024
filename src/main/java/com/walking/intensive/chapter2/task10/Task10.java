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

        System.out.println(isPalindrome("Муза, ранясь шилом опыта, ты помолишься на разумы"));
    }

    static String getStringLetters(String inputString) {

        StringBuilder stringLetters = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char symbol = inputString.toLowerCase().charAt(i);

            if (Character.isLetter(symbol)) {
                stringLetters.append(symbol);
            }
        }

        return stringLetters.toString();
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        String s = getStringLetters(inputString);
        boolean result = true;

        for (int i = 0; i < s.length(); i++) {
            char symbolLeft = s.charAt(i);
            char symbolRight = s.charAt(s.length() - 1 - i);

            if (symbolLeft != symbolRight) {
                result = false;
                break;
            }
        }

        return result;
    }
}
