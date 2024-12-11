package com.walking.intensive.chapter2.task10;

import java.util.Locale;

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
        String inputString = "   Муза,   ранясь !!! )шилом (опыта), ты помолишься на разум!?!   ";

        System.out.println(isPalindrome(inputString));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null) {
            return false;
        }

        // Удаляем пробелы и знаки препинания, затем переводим всё в нижний регистр
        inputString = inputString.replace(" ", "");
        inputString = inputString.replace(".", "");
        inputString = inputString.replace("!", "");
        inputString = inputString.replace(",", "");
        inputString = inputString.replace("?", "");
        inputString = inputString.replace("'", "");
        inputString = inputString.replace("(", "");
        inputString = inputString.replace(")", "");
        inputString = inputString.replace("-", "");
        inputString = inputString.replace("_", "");

        inputString = inputString.toLowerCase();

        if (inputString.length() <= 1) {
            return false;
        }

        int halfLength = inputString.length() / 2;
        int odd = inputString.length() % 2 == 0 // Чётность приведённой строки. Чтобы проверить лишь до половины строки.
                ? 1
                : 0;

        for (int i = 0; i <= halfLength; i++) {
            char leftLetter = inputString.charAt(i);
            char rightLetter = inputString.charAt(halfLength * 2 - odd - i);

            if (leftLetter != rightLetter) {
                return false;
            }
        }

        return true;
    }
}
