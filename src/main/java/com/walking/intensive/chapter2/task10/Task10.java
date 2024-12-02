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
        System.out.println(isPalindrome("Про?Сто, Очен. Стёчк!"));
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        String parsedString = removeSpecialCharacters(inputString);
        String backwardString = "";

        for (int i = 0; i < parsedString.length(); i++) {
            char c = parsedString.charAt(i);
            backwardString = c + backwardString;
        }

        return parsedString.equalsIgnoreCase(backwardString);
    }

    static String removeSpecialCharacters(String inputString) {
        String parsedString = "";

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я')) {
                parsedString += c;
            }
        }

        return parsedString;
    }
}
