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
        System.out.println(isPalindrome("Ежу хуже,!"));
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум.!"));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        int stringLength = inputString.length();
        int a = 0, z = stringLength - 1;
        while (a < stringLength / 2) {

            char c = inputString.charAt(a);
            if (!Character.isLetterOrDigit(c)) {
                a++;
                continue;
            }

            char d = inputString.charAt(z);
            if (!Character.isLetterOrDigit(d)) {
                z--;
                continue;
            }

            if (Character.toLowerCase(c) != Character.toLowerCase(d)) {
                return false;
            }

            a++; z--;
        }

        return true;
    }
}
