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

        System.out.println(isPalindrome("!Мут, / !т У,м"));
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        for (int i = 0, j = inputString.length() - 1; i < j; i++, j--) {

            char symbolLeft = inputString.toLowerCase().charAt(i);
            char symbolRight = inputString.toLowerCase().charAt(j);

            if (!Character.isLetter(symbolLeft)) {
                j++;
            } else if (!Character.isLetter(symbolRight)) {
                i--;
            } else if (symbolLeft != symbolRight) {
                return false;
            }
        }
        return true;
    }
}
