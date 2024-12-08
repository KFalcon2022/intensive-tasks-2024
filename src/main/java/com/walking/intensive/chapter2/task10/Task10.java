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
        String inputString = "Муза, ранясь шилом опыта, ты помолишься на разум";
        boolean result = isPalindrome(inputString);
        System.out.println(result);
    }

    static boolean isPalindrome(String inputString) {
        String ignorePunctuationSpacesCase = inputString.replaceAll("[^a-zA-Zа-яА-ЯёЁ0-9]", "").toLowerCase();

        int leftPartLine = 0;
        int rightPartLine = ignorePunctuationSpacesCase.length() - 1;

        while ((leftPartLine < rightPartLine)) {

            if (ignorePunctuationSpacesCase.charAt(leftPartLine) != ignorePunctuationSpacesCase.charAt(rightPartLine)) {
                return false;
            }

            leftPartLine++;
            rightPartLine--;
        }

        return true;
    }
}
