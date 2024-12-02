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
        System.out.println(isPalindrome("Кот, сука, за кусток"));
        System.out.println(isPalindrome("H1ello, world!"));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }
        String palindrome = inputString.toLowerCase();
        String normalized = "";

        for (int i = 0; i <palindrome.length(); i++) {
            if (Character.isLetter(palindrome.charAt(i))) {
                normalized += palindrome.charAt(i);
            }
        }

        String afterReverse = "";
        for (int i = normalized.length()-1; i >= 0; i--) {
            afterReverse += normalized.charAt(i);
        }

        return normalized.equals(afterReverse);
    }
}
