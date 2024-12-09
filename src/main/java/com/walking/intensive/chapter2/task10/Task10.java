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
        System.out.println(isPalindrome("ротор"));
        System.out.println(isPalindrome("ротkр"));
    }

    static boolean isPalindrome(String inputString) {
        // Ваш код
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        String str = inputString.toLowerCase()
                .replace(" ", "")
                .replace("!", "")
                .replace("?", "")
                .replace(",", "");


        for (int i = 0; i < (str.length() - 1) / 2; i++) {
            int j = str.length() - i - 1;
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
