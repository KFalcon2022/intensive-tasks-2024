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
        System.out.println(isPalindrome("А роза упала на лапу Азора"));
        System.out.println(isPalindrome("Hello, world!"));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) return false;

        String normalized = inputString.replaceAll("\\p{Punct}", "")
                .replaceAll("\\s", "").toLowerCase();

        return normalized.contentEquals(new StringBuilder(normalized).reverse());
    }
}
