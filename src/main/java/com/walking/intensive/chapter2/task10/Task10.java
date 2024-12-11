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

        String string = getString(inputString);
        int lettersQuantity = string.length();

        for (int i = 0; i < lettersQuantity; i++) {

            if (string.charAt(i) != string.charAt(lettersQuantity - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEmpty(String inputString) {

        return inputString == null || getString(inputString).isEmpty();
    }

    private static boolean isChar(String inputString) {

        return inputString.trim().length() == 1;
    }

    private static String getString(String inputString) {

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {

            char letter = inputString.toUpperCase().charAt(i);

            if (letter >= 'A' && letter <= 'Z'
                    || letter >= 'А' && letter <= 'Я'
                    || letter == 'Ё'
                    || letter >= '0' && letter <= '9') {

                string.append(letter);
            }
        }
        return string.toString();
    }
}