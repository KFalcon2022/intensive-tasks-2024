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
        String palindrome = "Муза! Ранясь шилом опыта, ты помолишься на разум.";
        if (isPalindrome(palindrome)) {
            System.out.println("Success");
        }
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

        inputString = inputString.toLowerCase();
        int stringLength = inputString.length();
        int iFromEnd = stringLength - 1;

        for (int i = 0; i < stringLength / 2; i++) {
            while (!isRusLetter(inputString.charAt(i))) {
                i++;
            }
            while (!isRusLetter(inputString.charAt(iFromEnd))) {
                iFromEnd--;
            }

            if (inputString.charAt(i) != inputString.charAt(iFromEnd)) {
                return false;
            }
            iFromEnd--;
        }

        return true;
    }

    public static boolean isRusLetter(char character) {
        String rusAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        if (rusAlphabet.indexOf(character) == -1) {
            return false;
        }

        return true;
    }
}
