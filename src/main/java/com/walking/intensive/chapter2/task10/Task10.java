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
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        int skipBegin = 0;
        int skipEnd = 0;

        for (int i = 0; i < inputString.length() / 2; i++) {
            int charBegin = inputString.charAt(i + skipBegin);
            int charEnd = inputString.charAt(inputString.length() - 1 - i - skipEnd);

            while (charBegin < 1040 || charBegin > 1103) {
                skipBegin++;
                charBegin = inputString.charAt(i + skipBegin);
            }

            while (charEnd < 1040 || charEnd > 1103) {
                skipEnd++;
                charEnd = inputString.charAt(inputString.length() - 1 - i - skipEnd);
            }

            if (charBegin != charEnd && Math.abs(charBegin - charEnd) != 32) {
                return false;
            }
        }

        return true;
    }
}
