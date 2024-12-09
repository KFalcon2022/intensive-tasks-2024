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
//        String testString = "Ты, милок, иди яром: у дороги мина, за дорогой огород," +
//                " а за ним и город у моря; иди, коли мыт";

        String testString = "A";

        if (isPalindrome(testString)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    static boolean isPalindrome(String inputString) {
        // Ваш код
        if (inputString == null) {
            return false;
        }

        String pureString = removePunctuation(inputString).toLowerCase();
        int stringLength = pureString.length();

        if (stringLength < 2) {
            return false;
        }

        for (int i = 0; i < stringLength; i++) {
            if (pureString.charAt(i) != pureString.charAt(stringLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static String removePunctuation(String inputString) {
        StringBuilder removedPunctuation = new StringBuilder();

        for (int i = 0; i <inputString.length() ; i++) {
            char symbol = inputString.charAt(i);

            if (isPunctuation(symbol)) {
                continue;
            }

            removedPunctuation.append(inputString.charAt(i));
        }

        return removedPunctuation.toString();
    }

    static boolean isPunctuation(char symbol) {
        final String PUNCTUATION = " !@#$%^&*()-=+_[]{};:'\",.<>/?\\";

        for (int i = 0; i < PUNCTUATION.length(); i++) {
            if (symbol == PUNCTUATION.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
