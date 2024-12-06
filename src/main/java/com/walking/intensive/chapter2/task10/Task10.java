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

        int i = 0;
        int j = inputString.length() - 1;

        while (i <= j) {
            char leftSymbol = Character.toLowerCase(inputString.charAt(i));
            char rightSymbol = Character.toLowerCase(inputString.charAt(j));

            if (Character.isLetter(leftSymbol) && Character.isLetter(rightSymbol) && leftSymbol == rightSymbol) {
                i++;
                j--;
            } else if (!Character.isLetter(leftSymbol)) {
                i++;
            } else if (!Character.isLetter(rightSymbol)) {
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
