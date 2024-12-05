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
        if ((inputString == null) || (inputString.equals("")) || (inputString.length() == 1)) {
            return false;
        }

        String punctuationMark = ".!,;:-? ";
        StringBuilder correctedString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentSymbol = inputString.charAt(i);
            if (!punctuationMark.contains(String.valueOf(currentSymbol))) {
                correctedString.append(currentSymbol);
            }
        }

        StringBuilder invertedString = new StringBuilder();

        for (int j = correctedString.length() - 1; j >= 0; j--) {
            invertedString.append(correctedString.charAt(j));
        }

        return correctedString.toString().equalsIgnoreCase(invertedString.toString());

    }
}
