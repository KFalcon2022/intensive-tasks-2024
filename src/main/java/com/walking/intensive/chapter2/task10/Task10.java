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
        String palindrome = "Муза! Ранясь шилом опыта, ты помолишься на разум.";
        if (isPalindrome(palindrome)) {
            System.out.println("Success");
        }
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        String prepared = inputString.replaceAll("[^а-яА-Я]", "").toLowerCase();

        for (int i = 0; i < prepared.length() / 2; i++) {
            if (prepared.charAt(i) != prepared.charAt(prepared.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
