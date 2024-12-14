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
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("   "));
        System.out.println(isPalindrome("  !!!!!! "));
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome("абвг 11 Гвба!"));
        System.out.println(isPalindrome("Abc 11 cba!"));
        System.out.println(isPalindrome("А роза. упала, на лапу Азора"));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            return false;
        }

        StringBuilder lowerCaseLiterals = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isLetterOrDigit(inputString.charAt(i))) {
                lowerCaseLiterals.append(Character.toLowerCase(inputString.charAt(i)));
            }
        }

        int length = lowerCaseLiterals.length();
        if (length < 2) {
            return false;
        }

        for (int i = 0; i < length / 2; i++) {
            if (lowerCaseLiterals.charAt(i) != lowerCaseLiterals.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
