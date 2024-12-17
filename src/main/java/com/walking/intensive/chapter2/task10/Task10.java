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
        String inputString = null;
        boolean result = isPalindrome(inputString);
        System.out.println(result);
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        int n = inputString.length();
        int leftPartLine = 0;
        int rightPartLine = n - 1;

        while (leftPartLine < rightPartLine) {

            while (leftPartLine < n) {
                char leftChar = inputString.charAt(leftPartLine);
                if (Character.isLetterOrDigit(leftChar)) {
                    break;
                }
                leftPartLine++;
            }

            while (rightPartLine >= 0) {
                char rightChar = inputString.charAt(rightPartLine);

                if (Character.isLetterOrDigit(rightChar)) {
                    break;
                }
                rightPartLine--;
            }

            if (leftPartLine >= rightPartLine) {
                break;
            }

            char leftChar = Character.toLowerCase(inputString.charAt(leftPartLine));
            char rightChar = Character.toLowerCase(inputString.charAt(rightPartLine));

            if (leftChar != rightChar) {
                return false;
            }

            leftPartLine++;
            rightPartLine--;
        }

        return true;
    }
}
