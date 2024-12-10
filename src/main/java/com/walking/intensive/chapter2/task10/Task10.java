package com.walking.intensive.chapter2.task10;

import javax.xml.transform.Source;

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
        System.out.println(isPalindrome("...............Решение неверное"));
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум.!"));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        String stringLower = inputString.toLowerCase();

        for (int a = 0, z = inputString.length() - 1; a < z; a++, z--) {
            while (!Character.isLetterOrDigit(stringLower.charAt(a))) {
                a++;
            }
            while (!Character.isLetterOrDigit(stringLower.charAt(z))) {
                z--;
            }

            if (stringLower.charAt(a) != stringLower.charAt(z)) {
                return false;
            }
        }

        return true;
    }
}
