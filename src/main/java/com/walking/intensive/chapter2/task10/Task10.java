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
//        Для собственных проверок можете делать любые изменения в этом методе
        String inputString = " Муза! Ранясь шилом опыта, ты помолишься на разум.";
        System.out.println(isPalindrome(inputString));

    }

    static boolean isPalindrome(String inputString) {
        // Ваш код
        if (inputString == null || inputString == "" || inputString.length() == 1) {
            return false;
        }

        String inputString1 = inputString.replaceAll("[\\s\\p{P}]", "");

        StringBuilder invertedString = new StringBuilder(new StringBuilder(inputString1).reverse().toString());

        return inputString1.equalsIgnoreCase(new String(invertedString));

    }
}
