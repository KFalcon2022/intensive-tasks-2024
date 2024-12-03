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
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум"));
    }

    static boolean isPalindrome(String inputString) {

        if (isEmpty(inputString) || isChar(inputString)) {
            return false;
        }
        char[] charArray = inputString.toUpperCase().toCharArray();
        StringBuilder string = new StringBuilder();
        StringBuilder invertedString = new StringBuilder();

        for (char c : charArray) {

            c = Character.toUpperCase(c);

            if (c >= 'A' && c <= 'Z' || c >= 'А' && c <= 'Я' || c == 'Ё') {

                string.append(c);
                invertedString.insert(0, c);
            }
        }
        return string.compareTo(invertedString) == 0;
    }

    private static boolean isEmpty(String inputString) {

        return inputString == null || inputString.trim().isEmpty();
    }

    private static boolean isChar(String inputString) {

        return inputString.trim().length() == 1;
    }
}