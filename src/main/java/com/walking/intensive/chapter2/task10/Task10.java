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
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null) {
            return false;
        }

        String lowerCaseString = inputString.toLowerCase();
        int length = inputString.length();

        if (length < 2) {
            return false;
        }

        for (int i = 0, j = length - 1; i < j; i++, j--) {
            while (lowerCaseString.charAt(i) < 1072 || lowerCaseString.charAt(i) > 1103) {
                i++;
            }
            while (lowerCaseString.charAt(j) < 1072 || lowerCaseString.charAt(j) > 1103) {
                j--;
            }

            if (lowerCaseString.charAt(i) != lowerCaseString.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
