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
        System.out.println(isPalindrome("Главрыба - абырвалг!"));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null) {
            return false;
        }

        if (inputString.length() <= 1) {
            return false;
        }

        String string = inputString.toLowerCase().replaceAll("[^а-я]", "");
        String stringReverse = reverse(string);

        return string.equals(stringReverse);
    }

    private static String reverse(String string) {
        StringBuilder res = new StringBuilder();
        int len = string.length();

        for (int i = 0; i < len; i++) {
            res.append(string.charAt(len - i - 1));
        }

        return res.toString();
    }
}
