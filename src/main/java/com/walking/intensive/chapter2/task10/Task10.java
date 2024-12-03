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
        System.out.println(getStringContainsOnlyLetters("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null) {
            return false;
        }

        String pureString = getStringContainsOnlyLetters(inputString);
        int length = pureString.length();

        if (length < 2) {
            return false;
        }

        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if (pureString.charAt(i) != pureString.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static String getStringContainsOnlyLetters(String s) {
        String lowerCaseString = s.toLowerCase();
        String result = lowerCaseString;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = lowerCaseString.charAt(i);

            if (currentChar < 1072 || currentChar > 1103) {
                result = result.replace("" + currentChar, "");
            }
        }

        return result;
    }
}
