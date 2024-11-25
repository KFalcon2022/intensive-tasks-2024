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
        String str = " ,d,d,d                  ";
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.isEmpty()) {
            return false;
        }

        String lowerCaseString = inputString.toLowerCase();
        boolean stringHasLetters = false;
        int i = 0;
        int j = lowerCaseString.length() - 1;

        while (i <= j) {

            if (!Character.isLetter(lowerCaseString.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetter(lowerCaseString.charAt(j))) {
                j--;
                continue;
            }

            if (lowerCaseString.charAt(i) != lowerCaseString.charAt(j)) {
                return false;
            }

            stringHasLetters = true;
            i++;
            j--;
        }

        return stringHasLetters;
    }
}
